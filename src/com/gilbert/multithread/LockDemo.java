package com.gilbert.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private static ReentrantLock lock = new ReentrantLock();
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(10000);
                    int k = 10;
                    k++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                countDownLatch.countDown();
            });
            thread.setName("Thread" + i);
            thread.start();
        }
        countDownLatch.await();
    }
}
