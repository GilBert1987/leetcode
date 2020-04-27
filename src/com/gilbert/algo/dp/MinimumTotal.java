package com.gilbert.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
//        例如，给定三角形：
//
//        [
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//        说明：
//
//        如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int [] sum = new int[triangle.size()];
        for (int i =0; i < triangle.size(); i++) {
            sum[i] = triangle.get(triangle.size() -1).get(i);
        }

        for (int i = triangle.size() - 2; i >=0 ; i--) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j< level.size(); j++) {
                sum[j] = level.get(j) + Math.min(sum[j], sum[j + 1]);
            }
        }
        return sum[0];
    }

    public static void main(String[] str) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(Arrays.asList(2));
        arrayLists.add(Arrays.asList(3,4));
        arrayLists.add(Arrays.asList(6,5,7));
        arrayLists.add(Arrays.asList(4,1,8,3));

        System.out.println(new MinimumTotal().minimumTotal(arrayLists));
    }
}
