package com.gilbert;

public class TreeNode {
    public static TreeNode NULL_NODE = new TreeNode(-1);
   public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeNode)) {
            return false;
        }
        return ((TreeNode)obj).val == val;
    }
}
