package com.gilbert.algo.linklist;

//https://leetcode-cn.com/problems/sort-list/
//148. 排序链表
//        在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
//        示例 1:
//
//        输入: 4->2->1->3
//        输出: 1->2->3->4
//        示例 2:
//
//        输入: -1->5->3->4->0
//        输出: -1->0->3->4->5
public class LinkSort {
    //
    public ListNode sortList(ListNode head) {
//        System.out.println("========");
//
//        ListUtils.print(head);

        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        //如果有两个节点的话，slow 应该不能动
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        ListNode right = sortList(slow.next);
        slow.next = null; // 链表断开，便于前面的排序
        ListNode left = sortList(head);
        return merge(right, left);
    }

    /**
     * 两个有序链表的归并排序
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head =new ListNode();
        ListNode p = l1;
        ListNode q = l2;
        ListNode k = head;
        while (p != null && q!= null) {
            if(p.val < q.val) {
                k.next = p;
                p = p.next;
            } else {
                k.next = q;
                q = q.next;
            }
            k = k.next;
        }
        k.next = p!=null? p : q;
        return head.next;
    }

    public static void main(String[] a) {
        ListUtils.print(new LinkSort().sortList(ListUtils.buildFromArray(new int[] {1,4,6,3,2,7})));
    }
}
