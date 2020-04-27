package com.gilbert.algo.tree;

import java.util.ArrayList;
import java.util.List;

// LC-98. 验证二叉搜索树
/**
 * 是否是有效的
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderValues = new ArrayList<>();
        inOrder(root, inOrderValues);
        for (int i = 0; i < inOrderValues.size() -1; i++) {
            if (inOrderValues.get(i) >= inOrderValues.get(i+ 1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ret);
        ret.add(root.val);
        inOrder(root.right, ret);
    }

    public static void main(String[] argv) {
        System.out.println(new IsValidBST().isValidBST(TreeUtils.buildTreeFromArray(new Integer[] {5,1,4,null,null,3,6})));
        System.out.println(new IsValidBST().isValidBST(TreeUtils.buildTreeFromArray(new Integer[] {5,1,8,null,null,6,9})));
    }
}
