package com.gilbert.algo.linklist;

// LeetCode-142. 环形链表 II

//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//        说明：不允许修改给定的链表。
//
//         
//
//        示例 1：
//
//        输入：head = [3,2,0,-4], pos = 1
//        输出：tail connects to node index 1
//        解释：链表中有一个环，其尾部连接到第二个节点。
//
//
//        示例 2：
//
//        输入：head = [1,2], pos = 0
//        输出：tail connects to node index 0
//        解释：链表中有一个环，其尾部连接到第一个节点。
//
//
//        示例 3：
//
//        输入：head = [1], pos = -1
//        输出：no cycle
//        解释：链表中没有环。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * 判断一个连标是否有环，返回环的第一个节点
 */
public class CycleLink {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
