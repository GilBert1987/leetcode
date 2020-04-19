package com.gilbert.design;

public class MyHashMap<K, V> {
    private volatile Node[] nodes; // 保证扩容的时候可见性

    class Node<K, V> {
        K key;
        volatile V value; // 保证修改的可见性
        volatile Node next; // 保证修改的可见性
    }
    // get不需要加锁
    // put 需要加锁 分段锁
    // 写操作修改节点的时候 需要原子化操作
}
