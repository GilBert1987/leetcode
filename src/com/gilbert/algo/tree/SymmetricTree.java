package com.gilbert.algo.tree;

// https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
//        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//            1
//           / \
//          2   2
//         / \ / \
//        3  4 4  3
//        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//            1
//           / \
//          2   2
//           \   \
//           3    3
//
//         
//
//        示例 1：
//
//        输入：root = [1,2,2,3,4,4,3]
//        输出：true
//        示例 2：
//
//        输入：root = [1,2,2,null,3,null,3]
//        输出：false

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] argv){
        TreeNode head = TreeUtils.buildTreeFromArray(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(new SymmetricTree().isSymmetric(head));

        head = TreeUtils.buildTreeFromArray(new Integer[]{1,2,2,null,3,null,3});
        System.out.println(new SymmetricTree().isSymmetric(head));
    }

}
