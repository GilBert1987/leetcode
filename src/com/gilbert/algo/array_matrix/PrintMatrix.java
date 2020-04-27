package com.gilbert.algo.array_matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
//面试题29. 顺时针打印矩阵
//        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
//        示例 1：
//
//        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[1,2,3,6,9,8,7,4,5]
//        示例 2：
//
//        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//        输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//        限制：
//
//        0 <= matrix.length <= 100
//        0 <= matrix[i].length <= 100
//        注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/

/**
 * 顺时针打印二维矩阵
 */
public class PrintMatrix {

    public List<Integer> printMatrix(int[] [] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (matrix == null) {
            return ret;
        }
        int tR = 0; //左上角的行
        int tC = 0; //左上角的列
        int dR = matrix.length - 1; //右下角的行
        int dC = matrix[0].length - 1; //右下角的列
        while(tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--, ret);
        }
        return ret;
    }

    /**
     * 打印矩阵的一圈的数据
     */
    private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC, List<Integer> res) {
        List<Integer> data = new ArrayList<>();
        if(tR == dR){ //左上角的行与右下角的行相等
            for(int i = tC; i <= dC; i++){
                data.add(matrix[tR][i]);
            }
        }else if(tC == dC){//左下角的列与右下角的列相等
            for(int i = tR; i <= dR; i++){
                data.add(matrix[i][tC]);
            }
        }else{
            int curC = tC;
            int curR = tR;
            while(curC != dC){
                data.add(matrix[tR][curC]);
                curC++;
            }
            while(curR != dR){
                data.add(matrix[curR][dC]);
                curR++;
            }
            while(curC != tC){
                data.add(matrix[dR][curC]);
                curC--;
            }
            while(curR != tR){
                data.add(matrix[curR][tC]);
                curR--;
            }
        }
        // printArray(data);
        res.addAll(data);
    }

    public static void printArray(List<Integer> res) {
        System.out.println(res.stream().map(e -> e + ",").collect(Collectors.joining()));
    }

    public static void main(String[] argv) {
        PrintMatrix.printArray(new PrintMatrix().printMatrix(new int[][] {{1, 2, 3 }, {4, 5, 6 }, {7, 8, 9}}));
    }
}
