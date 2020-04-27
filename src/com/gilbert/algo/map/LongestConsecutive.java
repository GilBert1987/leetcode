package com.gilbert.algo.map;

import java.util.HashMap;
import java.util.Map;

//128. 最长连续序列
//        给定一个未排序的整数数组，找出最长连续序列的长度。
//
//        要求算法的时间复杂度为 O(n)。
//
//        示例:
//
//        输入: [100, 4, 200, 1, 3, 2]
//        输出: 4
//        解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
// https://leetcode-cn.com/problems/longest-consecutive-sequence/

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                max = Math.max(max, getLegth(nums[i], map));
            }
        }
        return max;
    }

    private int getLegth(int num, Map<Integer, Integer> map) {
        int legth = 0;
        int p = num;
        if (map.get(p) == 1) {
            map.put(p, 0);
            legth++;
            while (map.get(p + 1) != null && map.get(p + 1) == 1) {
                map.put(p + 1, 0);
                legth++;
                p = p +1;
            }
            p = num;
            while (map.get(p - 1) != null && map.get(p - 1) == 1) {
                map.put(p - 1, 0);
                legth++;
                p = p - 1;
            }
        }
        return legth;
    }

    public static void main(String[] ar) {
        System.out.println(new LongestConsecutive().longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }
}
