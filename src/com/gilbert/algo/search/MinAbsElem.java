package com.gilbert.algo.search;

/**
 * 寻找绝对值最小的元素
 */

public class MinAbsElem {
    public static int minElem(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 0) {
            return -1;
        }
            if (nums[0] >= 0) {
            return nums[0];
        }
        if (nums[nums.length - 1] <= 0) {
            return nums[nums.length - 1];
        }
        int p = 0;
        int q = nums.length - 1;
        while (q - p > 1) {
            int mid = (p + q) /2;
            if (nums[mid] == 0) {
                return nums[mid];
            }
            if (nums[p] == nums[q]) {
                return nums[p];
            }
            if (nums[mid] > 0) {
                q = mid;
            } else if(nums[mid] < 0) {
                p = mid;
            }
        }
        return Math.abs(nums[p]) < Math.abs (nums[q]) ? nums[p] : nums[q];
    }

    public static void main(String [] argv) {
        System.out.println(new MinAbsElem().minElem(new int[] {1}));
        System.out.println(new MinAbsElem().minElem(new int[] {-2, 1}));
        System.out.println(new MinAbsElem().minElem(new int[] {-6, -5, -4}));
        System.out.println(new MinAbsElem().minElem(new int[] {0, 1, 4}));
        System.out.println(new MinAbsElem().minElem(new int[] {-6, 0,1, 4}));
        System.out.println(new MinAbsElem().minElem(new int[] {-6, 1,3, 4}));
    }
}
