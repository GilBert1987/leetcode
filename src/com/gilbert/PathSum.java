package com.gilbert;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
//
//
//        示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        返回:
//
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, ret, path);
        return ret;
    }

    private void pathSum(TreeNode node, int sum, List<List<Integer>> ret, List<Integer> path) {
        if (node == null) {
            return;
        }
        sum = sum - node.val;
        path.add(node.val);
        if(sum == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        pathSum(node.left, sum, ret, path);
        pathSum(node.right, sum, ret, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] argv) {
        printer(new PathSum().pathSum(TreeUtils.buildTreeFromArray(new Integer[]{5,4,8,11, null, 13,4, 7,2,null, null, null, null, 5,1}), 22));
    }

    private static void printer(List<List<Integer>> ret) {
        ret.stream().forEach(e -> System.out.println(e.stream().map(s -> s + ",").collect(Collectors.joining())));
    }
}
