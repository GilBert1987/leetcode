package com.gilbert;

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
