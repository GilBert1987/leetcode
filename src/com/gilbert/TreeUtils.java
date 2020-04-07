package com.gilbert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class TreeUtils {

    public static TreeNode buildTreeFromArray(Integer [] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root;
        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = 0; i < array.length; i++) {
            root = buildANode(array, i, nodes);
            if (root != null){
                root.left = buildANode(array, 2 * i + 1, nodes);
                root.right = buildANode(array, 2 * i + 2, nodes);
            }
        }
        return nodes[0];
    }

    public static void printTree(TreeNode root) {
        printTreeInner(root).stream().forEach(e -> printArray(e));
    }

    public static ArrayList<ArrayList<Integer>> printTreeInner(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        ArrayList ret = new ArrayList();
        if (root == null) {
            return ret;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null){
                    if (node.left == null) {
                        queue.offer(TreeNode.NULL_NODE);
                    }
                    queue.offer(node.right);
                }
                level.add(node.val);
            }
            ret.add(level);
        }
        return ret;
    }

    public static TreeNode buildANode(Integer [] array, int index, TreeNode[] nodes) {
        if (index > array.length - 1) {
            return null;
        }
        if (nodes[index] != null) {
            return nodes[index];
        }
        if (array[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.left = null;
        node.right = null;
        node.val = array[index];
        nodes[index] = node;
        return node;
    }

    public  static void main(String[]  arg) {
        printTree(buildTreeFromArray(new Integer[] {1,2,3,4,5,6, 7, 8}));
        printTree(buildTreeFromArray(new Integer[] {1,2,3,null,5,6, 7,null, null,8}));

    }

    private static void printArray(ArrayList<Integer> ar) {
        StringBuilder sb = new StringBuilder();
        ar.stream().forEach(e -> {
            if (e == -1) {
                sb.append("null,");
            } else {
                sb.append(e + ",");
            }
        });
        System.out.println(sb);
    }
}
