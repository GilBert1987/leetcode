package com.gilbert.algo.linklist;

// 面试题 02.05. 链表求和
// https://leetcode-cn.com/problems/sum-lists-lcci/

//给定两个用链表表示的整数，每个节点包含一个数位。
//
//        这些数位是反向存放的，也就是个位排在链表首部。
//
//        编写函数对这两个整数求和，并用链表形式返回结果。
//
//         
//
//        示例：
//
//        输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//        输出：2 -> 1 -> 9，即912
//        进阶：假设这些数位是正向存放的，请再做一遍。
//
//        示例：
//
//        输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//        输出：9 -> 1 -> 2，即912
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
