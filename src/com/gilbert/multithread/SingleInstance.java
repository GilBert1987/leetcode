package com.gilbert.multithread;

/**
 * 单利
 */
public class SingleInstance {
    private static volatile SingleInstance instance;
    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
