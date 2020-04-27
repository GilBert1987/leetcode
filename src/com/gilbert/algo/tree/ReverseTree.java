package com.gilbert.algo.tree;

public class ReverseTree {
    public static void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        reverse(root.left);
        reverse(root.right);
    }

    public static void main(String[] argv) {
        TreeNode root  = TreeUtils.buildTreeFromArray(new Integer[] {1,2,3,4,5,6});
        TreeUtils.printTree(root);
        reverse(root);
        TreeUtils.printTree(root);
    }
}
