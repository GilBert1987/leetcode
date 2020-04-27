package com.gilbert.algo.linklist;

// https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//        示例：
//
//        给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//        当删除了倒数第二个节点后，链表变为 1->2->3->5.
//        说明：
//
//        给定的 n 保证是有效的。
//
//        进阶：
//
//        你能尝试使用一趟扫描实现吗？

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        while (i< n +1 && p !=null) {
            p = p.next;
            i++;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        if (i < n +1) {
            //
            return head.next;
        }
        ListNode delNode = q.next;
        q.next = delNode.next;
        return head;
    }

    public static void main(String[] argv){
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        ListUtils.print(head);
        head = new RemoveNthFromEnd().removeNthFromEnd(head, 2);
        ListUtils.print(head);
    }

}
