package com.gilbert.algo.tree;

// 面试题55 - II. 平衡二叉树
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
//         
//
//        示例 1:
//
//        给定二叉树 [3,9,20,null,null,15,7]
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回 true 。
//
//        示例 2:
//
//        给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//        / \
//        2   2
//        / \
//        3   3
//        / \
//        4   4
//        返回 false 。

// https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
public class IsBalanceTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) +1;
    }

    public static void main(String [] argv) {
        System.out.println(new IsBalanceTree().isBalanced(TreeUtils.buildTreeFromArray(new Integer[] {3,9,20,null,null,15,7})));
        System.out.println(new IsBalanceTree().isBalanced(TreeUtils.buildTreeFromArray(new Integer[] {1,2,2,3,3,null,null,4,4})));
    }
}
