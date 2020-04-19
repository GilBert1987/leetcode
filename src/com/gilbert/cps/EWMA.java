package com.gilbert.cps;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * An exponentially-weighted moving average.
 *
 * @see <a href="http://www.teamquest.com/pdfs/whitepaper/ldavg1.pdf">UNIX Load Average Part 1: How
 *      It Works</a>
 * @see <a href="http://www.teamquest.com/pdfs/whitepaper/ldavg2.pdf">UNIX Load Average Part 2: Not
 *      Your Average Average</a>
 */
// 加权移动平均算法
public class EWMA {
    private static final int INTERVAL = 5;
    private static final double SECONDS_PER_MINUTE = 60.0D;
    private static final int ONE_MINUTE = 1;
    private static final int FIVE_MINUTES = 5;
    private static final int FIFTEEN_MINUTES = 15;
    private static final double M1_ALPHA = 1.0D - Math.exp(-0.08333333333333333D);
    private static final double M5_ALPHA = 1.0D - Math.exp(-0.016666666666666666D);
    private static final double M15_ALPHA = 1.0D - Math.exp(-0.005555555555555555D);
    private volatile boolean initialized = false; //volatile 保证内存可见性
    private volatile double rate = 0.0D; //volatile 保证内存可见性
    private final AtomicLong uncounted = new AtomicLong();
    private final double alpha;
    private final double interval;

    public static EWMA oneMinuteEWMA() {
        return new EWMA(M1_ALPHA, 5L, TimeUnit.SECONDS);
    }

    public static EWMA fiveMinuteEWMA() {
        return new EWMA(M5_ALPHA, 5L, TimeUnit.SECONDS);
    }

    public static EWMA fifteenMinuteEWMA() {
        return new EWMA(M15_ALPHA, 5L, TimeUnit.SECONDS);
    }

    public EWMA(double alpha, long interval, TimeUnit intervalUnit) {
        this.interval = (double)intervalUnit.toNanos(interval);
        this.alpha = alpha;
    }

    /**
     * 打点调用这个方法增加统计次数
     */
    public void update(long n) {
        this.uncounted.addAndGet(n);
    }

    /**
     * 有一个线程池，
     *         this.future = tickThread.scheduleAtFixedRate(new Runnable() {
     *             @Override
     *             public void run() {
     *                 tick(); // 每隔一秒钟调用一次
     *             }
     *         }, INTERVAL, INTERVAL, TimeUnit.SECONDS);
     */
    public void tick() {
        long count = this.uncounted.getAndSet(0L); // 获取老的数据，设置成新的数值，getAndSet 保证是获取的最新的数据 CAS 自旋转
        double instantRate = (double)count / this.interval;
        if (this.initialized) {
            this.rate += this.alpha * (instantRate - this.rate);
        } else {
            this.rate = instantRate;
            this.initialized = true;
        }

    }

    /**
     * 定时获取打点数据,上报
     */
    public double rate(TimeUnit rateUnit) {
        return this.rate * (double)rateUnit.toNanos(1L);
    }

    public static void main(String[] argv) {
        EWMA.oneMinuteEWMA().update(100);
    }
}
