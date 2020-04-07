package com.gilbert;
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
