package com.gilbert;

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
