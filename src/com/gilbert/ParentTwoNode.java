package com.gilbert;

public class ParentTwoNode {

    public static TreeNode getParentOfTwoNode(TreeNode root, TreeNode node1, TreeNode node2) {

        if(root == null || root.equals(node1)  || root.equals(node2)) {
            return root;
        }
        TreeNode left = getParentOfTwoNode(root.left, node1, node2);
        TreeNode right = getParentOfTwoNode(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null? left : right;
    }

    public static void main(String[] arr) {
        TreeNode root = TreeUtils.buildTreeFromArray(new Integer[] {1,2,3,4,5,6,7,8,9});
        TreeUtils.printTree(root);
        System.out.println(getParentOfTwoNode(root, new TreeNode(8), new TreeNode(3)).val);
        System.out.println(getParentOfTwoNode(root, new TreeNode(8), new TreeNode(4)).val);
    }
}
