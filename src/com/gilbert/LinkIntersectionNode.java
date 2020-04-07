package com.gilbert;

public class LinkIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int difference = Math.abs(lengthA - lengthB);
        if (difference > 0) {
            if (lengthA > lengthB) {
                while (difference > 0) {
                    headA = headA.next;
                    difference--;
                }
            } else {
                while (difference > 0) {
                    headB = headB.next;
                    difference--;
                }
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
