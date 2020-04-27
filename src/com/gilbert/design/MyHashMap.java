package com.gilbert.design;

// get不需要加锁
// put 需要加锁 分段锁
// 写操作修改节点的时候 需要原子化操作

// https://blog.csdn.net/shuaicenglou3032/article/details/77745999

// HashMap 写操作为什么不是线程安全的?
/**
 * 实现一个简单的HashMap
 */
public class MyHashMap {
    /**
     * 静态内部类
     * 创建静态内部类的时候是不需要讲静态内部类的实例对象绑定到外部类的实例对象上
     * 静态内部类属于外部类，而不是属于外部类的对象。
     * 只访问外部类的静态成员变量或者静态方法。
     */
    static class Node {
        Object key;
        volatile Object value; // 保证修改的可见性
        volatile Node next; // 保证修改的可见性
    }

    private volatile Node[] nodes; // 保证扩容的时候可见性
    private int nodeSize = 0;

    public MyHashMap(int nodeSize) {
        this.nodeSize = nodeSize;
        nodes = new Node[nodeSize];
    }

    public Object getValue(Object key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    private Node getNode(Object key) {
        if (key == null) {
            throw new IllegalStateException("key can not be null");
        }
        int index = index(key);
        Node node  = nodes[index];
        while (node != null && !key.equals(node.key)) {
            node = node.next;
        }
        return node;
    }

    public void put(Object key, Object value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        Node newNode = new Node();
        newNode.value = value;
        newNode.key = key;

        int index = index(key);
        Node pre  = nodes[index];
        if (pre == null) {
            nodes[index] = newNode;
            return;
        }
        Node tail = pre.next;
        while (tail != null) {
            pre = tail;
            tail = tail.next;
        }
        pre.next = newNode;
        return;
    }

    private int index(Object key) {
        return key.hashCode() % nodeSize;
    }
}
