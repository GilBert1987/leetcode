package com.gilbert.algo.dp;

//53. 最大子序和
//        给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//        示例:
//
//        输入: [-2,1,-3,4,-1,2,1,-5,4],
//        输出: 6
//        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// https://leetcode-cn.com/problems/maximum-subarray/

public class MaxSubArray {
    public static int maxSubArray(int [] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int curMax  = nums[0];
        for (int i = 1; i< nums.length; i++) {
            if (curMax < 0) {
                curMax = nums[i];
            } else {
                curMax = nums[i] + curMax;
            }
            maxSum = Math.max(curMax, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] ar) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
