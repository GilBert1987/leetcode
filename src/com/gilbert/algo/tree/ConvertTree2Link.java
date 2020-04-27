package com.gilbert.algo.tree;

import com.gilbert.algo.linklist.ListNode;
import com.gilbert.algo.linklist.ListUtils;

public class ConvertTree2Link {
    /**
     * 注意Last 需要是成员变量
     */
    private ListNode last;
    public ListNode convert(TreeNode root) {
        ListNode head = new ListNode(-1);
        last = head;
        inOrder(root);
        return head.next;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        ListNode node = new ListNode(root.val);
        last.next = node;
        last = node;
        inOrder(root.right);
    }

    public static void main(String [] argv) {
        TreeNode root = TreeUtils.buildTreeFromArray(new Integer[]{1, 2, 3, null, 4, 5, null});
        ListNode head = new ConvertTree2Link().convert(root);
        ListUtils.print(head);
    }
}
