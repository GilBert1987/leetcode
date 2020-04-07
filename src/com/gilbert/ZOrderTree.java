package com.gilbert;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//        例如：
//        给定二叉树 [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回锯齿形层次遍历如下：
//
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]
//        通过次数41,184提交次数76,179
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


// 队列的头永远都是最右边的节点

public class ZOrderTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int direction = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                if (direction == 0) {
                    node = queue.pollLast();
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                }
                if (direction == 1) {
                    node = queue.poll();
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
                level.add(node.val);
            }
            ret.add(level);
            direction = direction == 0 ? 1 :0;
        }
        return ret;
    }

    public static void main(String [] str) {
        List<List<Integer>> ret = new ZOrderTree().zigzagLevelOrder(TreeUtils.buildTreeFromArray(new Integer[] {3,9,20,null,null,15,7}));
        ret.stream().forEach(e -> {
            System.out.println(e.stream().map(s -> s + ",").collect(Collectors.joining()));
        });
    }
}
