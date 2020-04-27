package com.gilbert.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//        示例:
//
//        输入: [1,2,3,null,5,null,4]
//        输出: [1, 3, 4]
//        解释:
//
//        1            <---
//        /   \
//        2     3         <---
//        \     \
//        5     4       <---
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node  = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ret;
    }

    public static void main(String[] argv) {
        List<Integer> ret = new RightSideView().rightSideView(TreeUtils.buildTreeFromArray(new Integer[] {1,2,3,null,5,null,4}));
        System.out.println(ret.stream().map(e -> e + ",").collect(Collectors.joining()));
    }
}
