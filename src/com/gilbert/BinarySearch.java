package com.gilbert;

/**
 * 数组的二分查找
 */
public class BinarySearch {
    public boolean search(int [] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int low  = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid  = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else  {
                high = mid -1;
            }
        }
        return false;
    }

    public static void main(String[]  argv) {
        System.out.println(new BinarySearch().search(new int[] {1,2}, 3));
        System.out.println(new BinarySearch().search(new int[] {1,2}, 1));
    }
}
