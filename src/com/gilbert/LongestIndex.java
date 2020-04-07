package com.gilbert;

// 1,3,5,4,7
// 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
//
//输入: [1,3,5,4,7]
//        输出: 3
//        解释: 最长连续递增序列是 [1,3,5], 长度为3。
//        尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
//
//输入: [2,2,2,2,2]
//        输出: 1
//        解释: 最长连续递增序列是 [2], 长度为1。
public class LongestIndex {
    public static  int findLongestIndex(int[] nums) {
        int maxLength =1;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i -1]) {
                currentLength = currentLength + 1;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }
}