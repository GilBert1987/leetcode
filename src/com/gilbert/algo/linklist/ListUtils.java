package com.gilbert.algo.linklist;

import com.gilbert.algo.linklist.ListNode;

public class ListUtils {
    public static ListNode buildFromArray(int[] array) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0 ; i< array.length; i++) {
            ListNode n = new ListNode();
            n.val = array[i];
            n.next = null;
            p.next = n;
            p = n;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        StringBuilder sn = new StringBuilder();
        while (head != null) {
            sn.append(head.val + ",");
            head = head.next;
        }
        System.out.println(sn.toString());
    }
}
