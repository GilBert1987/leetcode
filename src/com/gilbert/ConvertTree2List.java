package com.gilbert;

// 将一个二叉树转为 链表
//给定一个二叉树，原地将它展开为链表。
//
//        例如，给定二叉树
//
//
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        将其展开为：
//
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6
// 参考 https://segmentfault.com/a/1190000018809812
public class ConvertTree2List {
    private TreeNode pre;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public static void main(String[] argv) {
        TreeNode root = TreeUtils.buildTreeFromArray(new Integer[]{1, 2,5,3,4,null, 6});
        new ConvertTree2List().flatten(root);
        StringBuilder sb = new StringBuilder();
        while (root !=null) {
            sb.append(root.val + ",");
            root = root.right;
        }
        System.out.println(sb);
    }
}
