package com.gilbert.algo.array_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/3sum/
//15. 三数之和
//        给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。
//
//
//
//        示例：
//
//        给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//        满足要求的三元组集合为：
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]

public class TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ret;
        }

        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 2; k ++){
            if (k > 0) {
                if (nums[k] == nums[k -1]){
                    continue;
                }
            }
            if (nums[k] > 0) {
                break;
            }
            int i  = k +1;
            int j = nums.length -1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++;
                    j--;
                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] ar) {
        List<List<Integer>> ret = new TreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ret);
    }
}
