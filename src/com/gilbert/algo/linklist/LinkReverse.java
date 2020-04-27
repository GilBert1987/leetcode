package com.gilbert.algo.linklist;

// https://leetcode-cn.com/problems/reverse-linked-list/

//206. 反转链表
//        反转一个单链表。
//
//        示例:
//
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
public class LinkReverse {
    public ListNode reverseList(ListNode head) {
        ListNode neeHead = new ListNode();
        while (head != null) {
            ListNode p = head;
            head = head.next;
            p.next = neeHead.next;
            neeHead.next = p;
        }
        return neeHead.next;
    }

    public static void main(String[] a) {
        ListUtils.print(new LinkReverse().reverseList(ListUtils.buildFromArray(new int[] {3,5,7,1})));
    }
}
