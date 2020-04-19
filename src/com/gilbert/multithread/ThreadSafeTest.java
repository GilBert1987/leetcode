package com.gilbert.multithread;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

// 内存模型
public class ThreadSafeTest {
    static class Bucket {
        long time;
//        long count; 无法线程安全
// volatile long count; // 无法线程安全
        public AtomicLong count; // 什么是CAS ?
//        public LongAdder count; // 更优化的实现

        public Bucket(long time, long count) {
            this.time = time;
            this.count = new AtomicLong(count);
        }
    }
//    Bucket lastBucket = new Bucket(0, 0);

    public AtomicReference<Bucket> lastBucket = new AtomicReference<>(new Bucket(0, 0));
    public Bucket lastBucket2 = new Bucket(0, 0);

    public volatile Bucket lastBucket3 = new Bucket(0, 0);

    public Bucket lastBucket4 = new Bucket(0, 0);
    private Object monitor = new Object();

    // volatile 的概念 是否能保证线程安全

    public void update4(long time) throws InterruptedException {
        synchronized(monitor) {
            if (time > lastBucket4.time) {
                Thread.sleep(100); // sleep 和wait的区别是什么
                lastBucket4 = new Bucket(time, 0);
            }
            lastBucket4.count.getAndAdd(1);
        }
    }


    /**
     * 这段代码的问题是什么
     * @param time
     */
    public void update3(long time) throws InterruptedException {
        if (time > lastBucket3.time) {
            Thread.sleep(100);
            lastBucket3 = new Bucket(time, 0);
        }
        lastBucket3.count.getAndAdd(1);
    }

    /**
     * 这段代码的问题是什么
     * @param time
     */
    public void update2(long time) throws InterruptedException {
        if (time > lastBucket2.time) {
            Thread.sleep(100);
            lastBucket2 = new Bucket(time, 0);
        }
        lastBucket2.count.getAndAdd(1);
    }

    public void update(long time) throws InterruptedException{
        Bucket old = lastBucket.get();
        if (time > old.time) {
            Thread.sleep(100);

            Bucket newBucket = new Bucket(time, 0);
            boolean bRet = lastBucket.compareAndSet(old, newBucket);
            if (bRet) {
                old = newBucket;
            } else {
                old = lastBucket.get();
            }
        }
        old.count.getAndAdd(1);
    }

    /**
     *
     * @param argv
     * @throws Exception
     */
    // LinkedBlockingQueue 实现原理

    public static void main(String[] argv) throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        ThreadSafeTest autmicTest = new ThreadSafeTest();
        final long time = System.currentTimeMillis() / 1000 * 1000;
        for (int i = 0; i < 100000; i++) {
            executor.execute(new Runnable() {
                /**
                 * 执行过程是什么
                 * 到底有多少线程在执行
                 */
                @Override
                public void run() {
                    System.out.println(executor.getActiveCount());
                    try {
                        autmicTest.update(time);
                        autmicTest.update2(time);
                        autmicTest.update3(time);
                        autmicTest.update4(time);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
            });
        }
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(autmicTest.lastBucket.get().count);
        System.out.println(autmicTest.lastBucket2.count);
        System.out.println(autmicTest.lastBucket3.count);
        System.out.println(autmicTest.lastBucket4.count);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        // 实现机制是什么
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {

            }
        }, 1, TimeUnit.SECONDS);

        Executors.newFixedThreadPool(3); // 内存没有限制
        Executors.newSingleThreadExecutor(); // 内存没有限制
        Executors.newCachedThreadPool(); // 内存有限制，线程没有限制
    }

//
//    Map<Long, Bucket> buckets = new ConcurrentHashMap<>();
//
//    public void update(long n) {
//        Long time = System.currentTimeMillis() / 1000 * 1000;
//        Bucket bucket = buckets.putIfAbsent(time,  new Bucket(time, n));
//        bucket.count.getAndAdd(n);
//    }
}
