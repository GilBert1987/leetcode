package com.gilbert;

/**
 * 判断一个连标是否有环，返回环的第一个节点
 */
public class CycleLink {
    public static boolean hasCircle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
