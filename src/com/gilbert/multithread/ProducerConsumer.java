package com.gilbert.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 生产者消费者模型
 */
public class ProducerConsumer {
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    private volatile List<Integer> products = new ArrayList<>(10);
    private Integer maxSize = 10;
    public ProducerConsumer(int maxSize) {
        this.maxSize = maxSize;
    }

    public void produce(Integer id) {
        if (id == null) {
            return;
        }
        try {
            lock.lock();
            while (products.size() == maxSize) { // 使用if 还是 while 什么叫做 假唤醒
                System.out.println("producer waiting");
                // 线程状态 sleep 和 await 的区别
                producer.await(); // 调用await 的时候发生了什么
                // 加入条件队列
                // 释放锁，从同步队列中摘除，修改state
                // Park 等待被唤醒
                //https://www.jianshu.com/p/cc308d82cc71
            }
            products.add(id);
            System.out.println("produces" + id);
            consumer.signalAll(); // 调用 singal 或者singnalAll 的时候发生了什么
            /**
             *
             */
        } catch (InterruptedException ex) {

        } finally {
            lock.unlock();
        }
    }

    public Integer consume() {
        Integer ret = null;
        try {
            lock.lock();
            while (products.size() == 0) {
                System.out.println("consumer waiting");
                consumer.await();
            }
            ret = products.remove(products.size() -1);
            System.out.println("consume" + ret);
            producer.signalAll();
        } catch (InterruptedException ex) {

        } finally {
            lock.unlock();
        }
        return ret;
    }

    public static void main(String[] argv) throws Exception{
        ProducerConsumer producerConsumer = new ProducerConsumer(10);
        new Thread(new Runnable() {

            @Override
            public void run() {
                IntStream.range(0, 100).forEach(e -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {

                    }
                    producerConsumer.produce(e);
                });
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {

                    }
                    Integer c = producerConsumer.consume();
                }
            }
        }).start();
        Thread.sleep(10000);
    }
}
