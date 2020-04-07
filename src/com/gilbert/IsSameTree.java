package com.gilbert;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null  && q != null) && q.val == p.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] argv) {
        System.out.println(new IsSameTree().isSameTree(TreeUtils.buildTreeFromArray(new Integer[] {1,2}), TreeUtils.buildTreeFromArray(new Integer[] {1,null,2})));

        System.out.println(new IsSameTree().isSameTree(TreeUtils.buildTreeFromArray(new Integer[] {1,2, 3}), TreeUtils.buildTreeFromArray(new Integer[] {1,2,3})));
    }
}
