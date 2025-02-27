package com.gilbert.algo.array_matrix;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
//        示例 1:
//
//        输入: [1,2,3,4,5,6,7] 和 k = 3
//        输出: [5,6,7,1,2,3,4]
//        解释:
//        向右旋转 1 步: [7,1,2,3,4,5,6]
//        向右旋转 2 步: [6,7,1,2,3,4,5]
//        向右旋转 3 步: [5,6,7,1,2,3,4]
//        示例 2:
//
//        输入: [-1,-100,3,99] 和 k = 2
//        输出: [3,99,-1,-100]
//        解释:
//        向右旋转 1 步: [99,-1,-100,3]
//        向右旋转 2 步: [3,99,-1,-100]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/rotate-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.Arrays;
import java.util.stream.Collectors;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length -1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] argv) {
        int [] nums = new int[] {1,2,3,4,5,6,7};
        new RotateArray().rotate(nums, 3);
        System.out.println(Arrays.stream(nums).mapToObj(e -> e + ",").collect(Collectors.joining()));
    }
}
