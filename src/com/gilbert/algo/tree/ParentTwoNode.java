package com.gilbert.algo.tree;

//236. 二叉树的最近公共祖先
//        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//        例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class ParentTwoNode {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

        if(root == null || root.equals(node1)  || root.equals(node2)) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null? left : right;
    }

    public static void main(String[] arr) {
        TreeNode root = TreeUtils.buildTreeFromArray(new Integer[] {1,2,3,4,5,6,7,8,9});
        TreeUtils.printTree(root);
        System.out.println(lowestCommonAncestor(root, new TreeNode(8), new TreeNode(3)).val);
        System.out.println(lowestCommonAncestor(root, new TreeNode(8), new TreeNode(4)).val);
    }
}
