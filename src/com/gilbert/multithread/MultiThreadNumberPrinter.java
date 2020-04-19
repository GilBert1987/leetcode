package com.gilbert.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印 奇数和偶数
 */
public class MultiThreadNumberPrinter{

    interface INumberPrinter {
        void print();
    }

    static class NumberPrinterUsingSync implements INumberPrinter {
        private Object monitor = new Object();
        private final int limit;
        private volatile int count = 0;
        private CountDownLatch countDownLatch;


        public NumberPrinterUsingSync(int limit, int initCount, CountDownLatch countDownLatch) {
            this.limit = limit;
            count = initCount;
            this.countDownLatch = countDownLatch;

        }
        @Override
        public void print() {
            synchronized (monitor) {
                while (count < limit) {
                    System.out.println(String.format("线程[%s]正在打印数字 %d", Thread.currentThread().getName(), ++count));
                    monitor.notifyAll();
                    try {
                        monitor.wait();
                    } catch (InterruptedException ex) {

                    }
                }
            }
            countDownLatch.countDown();
        }
    }

    static class NumberPrinterUsingLock implements INumberPrinter {
        private Lock numberPrinterLock = new ReentrantLock();
        private Condition numberCondition = numberPrinterLock.newCondition();
        private final int limit;
        private volatile int count = 0;
        private CountDownLatch countDownLatch;

        public NumberPrinterUsingLock(int limit, int initCount, CountDownLatch countDownLatch) {
            this.limit = limit;
            count = initCount;
            this.countDownLatch = countDownLatch;
        }

        public void print() {
            numberPrinterLock.lock();
            try {
                while (count < limit) {
                    System.out.println(String.format("线程[%s]正在打印数字 %d", Thread.currentThread().getName(), ++count));
                    numberCondition.signalAll();
                    try {
                        numberCondition.await();
                    } catch (InterruptedException ex) {

                    }
                }
            } catch (Exception ex) {
                numberPrinterLock.unlock();
            }
            countDownLatch.countDown();
        }
    }

    private static void test(int i) throws Exception {
        INumberPrinter numberPrinter;
        CountDownLatch countDownLatch = new CountDownLatch(2);
        if (i == 0) {
            numberPrinter = new NumberPrinterUsingLock(100, 0, countDownLatch);
        } else {
            numberPrinter = new NumberPrinterUsingSync(100, 0, countDownLatch);
        }
        Thread thread1 = new Thread(numberPrinter::print, (i == 0 ? "Lock": "Sync") + "thread-1");
        Thread thread2 = new Thread(numberPrinter::print, (i == 0 ? "Lock": "Sync") + "thread-2");
        thread1.start();
        thread2.start();
        countDownLatch.await();
    }

    public static void main(String[] argv) throws Exception {
        test(1);
        // test(0);
    }
}

