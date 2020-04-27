package com.gilbert.algo.dp;

import com.sun.tools.javac.util.Assert;

//64. 最小路径和
//        给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//        说明：每次只能向下或者向右移动一步。
//
//        示例:
//
//        输入:
//        [
//        [1,3,1],
//        [1,5,1],
//        [4,2,1]
//        ]
//        输出: 7
//        解释: 因为路径 1→3→1→1→1 的总和最小。
// https://leetcode-cn.com/problems/minimum-path-sum/

public class MinPathSum {

    public static int minPathSum(int [] [] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] [] arr = new int[row][col];
        arr[0][0] = grid[0][0];
        for (int i = 1; i < row; i ++) {
            arr[i][0] = arr[i -1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i ++) {
            arr[0][i] = arr[0][i -1] + grid[0][i];
        }

        for (int i = 1;i < row; i++) {
            for (int j = 1; j< col; j++){
                arr[i][j] = Math.min(arr[i -1][j], arr[i][j -1]) + grid[i][j];
            }
        }
        return arr[row -1][col -1];
    }

    public static void main(String[] a) {
        int[] []  grid = new int[][]{{1,2,1}, {1,5,4}, {2,4,1},{1,1,1}};
        Assert.check(minPathSum(grid) == 7);
    }
}
