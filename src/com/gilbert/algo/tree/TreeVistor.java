package com.gilbert.algo.tree;

import java.util.Stack;

public class TreeVistor {

    public void visitorPre(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        visitorPre(root.left);
        visitorPre(root.right);
    }

    public void visitorPreStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(root.val);
            stack.push(node.left);
            stack.push(node.right);
        }
    }
}
