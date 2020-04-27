package com.gilbert.algo.linklist;

//21. 合并两个有序链表
// https://leetcode-cn.com/problems/merge-two-sorted-lists/
//        将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//        示例：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4

public class LinkMerge {
    public static ListNode merge(ListNode l1 , ListNode l2) {
        ListNode node = new ListNode();
        node.next = null;
        ListNode k = node;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if(p.val < q.val) {
                k.next = p;
                p = p.next;
            } else {
                k.next = q;
                q = q.next;
            }
            k = k.next;
        }
        k.next = p != null ? p : q;
        return node.next;
    }

    public static void main(String[] a) {
        ListUtils.print(merge(ListUtils.buildFromArray(new int[] {1,3,6}), ListUtils.buildFromArray(new int[] {4,5})));
    }
}
