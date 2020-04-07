package com.gilbert;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;

class DLinkNode {
    int val;
    String key;
    DLinkNode next;
    DLinkNode pre;

    public DLinkNode(int val, String key) {
        this.val = val;
        this.key = key;
        next = null;
        pre = null;
    }
}

/**
 * LRU cache
 */
public class LRU {
    HashMap<String, DLinkNode> map;
    DLinkNode head;
    DLinkNode tail;
    int capcity;
    int curSize;

    public LRU(int capcity) {
        if (capcity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capcity = capcity;
        curSize = 0;
        map = new HashMap<>();
        head = new DLinkNode(-1, "Head");
        tail = new DLinkNode(-1, "Tail");
        head.next = tail;
        head.pre = null;
        tail.pre= head;
        tail.next = null;
    }

    public Integer get(String key) {
        DLinkNode node  = map.get(key);
        if (node == null) {
            return null;
        }
        move2Head(node);
        return node.val;
    }

    public void put(String key, Integer val) {
        DLinkNode node  = map.get(key);
        if (node != null) {
            node.val = val;
            move2Head(node);
        } else {
            DLinkNode newNode = new DLinkNode(val, key);
            add2Head(newNode);
            curSize++;
            map.put(key, newNode);
            if(curSize > capcity) {
                DLinkNode rNode = tail.pre;
                removeNode(rNode);
                map.remove(rNode.key);
                curSize--;
            }
        }

    }

    private void move2Head(DLinkNode node) {
        removeNode(node);
        add2Head(node);
    }

    private void add2Head(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        node.pre.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }

    public static void main(String[] ar) {
        LRU lru = new LRU(3);
        lru.put("1", 1);
        lru.put("2", 1);
        lru.put("3", 1);
        lru.put("4", 1);
        Assert.checkNull(lru.get("1"));
        Assert.checkNonNull(lru.get("4"));

    }
}
