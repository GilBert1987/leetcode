package com.gilbert.algo.tree;

// https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
//面试题55 - I. 二叉树的深度
//        输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
//        例如：
//
//        给定二叉树 [3,9,20,null,null,15,7]，
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回它的最大深度 3 。


public class TreeDepth {
    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return Math.max(right, left) +1;
    }

    public static void main(String[] args) {
        System.out.println(getTreeDepth(TreeUtils.buildTreeFromArray(new Integer[]{1, 2, 3, 4})));
        System.out.println(getTreeDepth(TreeUtils.buildTreeFromArray(new Integer[]{1, 2, 3, 4,5,6,7,8})));
    }
}
