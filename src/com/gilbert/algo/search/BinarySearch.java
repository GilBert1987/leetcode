package com.gilbert.algo.search;

// LeetCode-704 二分查找
//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
//
//
//        示例 1:
//
//        输入: nums = [-1,0,3,5,9,12], target = 9
//        输出: 4
//        解释: 9 出现在 nums 中并且下标为 4
//        示例 2:
//
//        输入: nums = [-1,0,3,5,9,12], target = 2
//        输出: -1
//        解释: 2 不存在 nums 中因此返回 -1
public class BinarySearch {
    public int search(int [] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low  = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid  = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else  {
                high = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[]  argv) {
        System.out.println(new BinarySearch().search(new int[] {-1,0,3,5,9,12}, 9));
        System.out.println(new BinarySearch().search(new int[] {-1,0,3,5,9,12}, 2));
    }
}
