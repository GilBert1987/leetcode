package com.gilbert.multithread;

import java.text.SimpleDateFormat;
import java.util.Date;

// 什么是ThreadLocal
// 内存泄露 value 内存泄露的问题
// Thread--> ThreadLocalMap --> key[null] value
public class ThreadLocalTest {
    private ThreadLocal<SimpleDateFormat> sdfHolder = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public void test() {
        sdfHolder.get().format(new Date());
        // sdfHolder.remove();
    }
}
