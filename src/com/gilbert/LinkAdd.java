package com.gilbert;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807
public class LinkAdd {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode head = new ListNode(-1);

        ListNode p = head;
        while (l1 != null && l2 != null) {
            int ret = jinwei + l1.val + l2.val;
            ListNode newNode = new ListNode(ret % 10);
            l1 = l1.next;
            l2 = l2.next;
            jinwei = ret / 10;
            p.next = newNode;
            p = p.next;
        }
        ListNode k = l1 != null? l1 : l2;
        while (k != null) {
            int ret = jinwei + k.val;
            ListNode newNode = new ListNode(ret % 10);
            jinwei = ret / 10;
            p.next = newNode;
            p = p.next;
            k = k.next;
        }
        if (jinwei != 0) {
            ListNode newNode = new ListNode(jinwei);
            p.next = newNode;
        }
        return head.next;
    }

    public static void main(String[]  a) {
        ListNode head1 = new ListNode(1);
        ListNode p = head1;
        p.next = new ListNode(8);

        ListNode head2 = new ListNode(0);

        addTwoNumbers(head1, head2);
    }
}
