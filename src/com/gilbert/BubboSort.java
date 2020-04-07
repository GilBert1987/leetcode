package com.gilbert;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 冒泡排序
 */
public class BubboSort {
    public void sort(int [] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int currentSize = nums.length - 1;
        boolean hasSwap = true;
        while (currentSize > 0 && hasSwap) {
            hasSwap = false;
            /**
             * 一次冒泡将最大当前currentSize内的最大值调整到最后一个
             */
            for (int i = 0; i < currentSize; i++) {
                if (nums[i] > nums[i + 1]) {
                    hasSwap = true;
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
            currentSize--;
        }
    }

    public static void main(String[] argv) {
        int []  nums = new int[] {1,3,4,2,7,5};
        new BubboSort().sort(nums);
        System.out.println(Arrays.stream(nums).mapToObj(e -> e + ",").collect(Collectors.joining()));

        nums = new int[] {3,2};
        new BubboSort().sort(nums);
        System.out.println(Arrays.stream(nums).mapToObj(e -> e + ",").collect(Collectors.joining()));

        nums = new int[] {1};
        new BubboSort().sort(nums);
        System.out.println(Arrays.stream(nums).mapToObj(e -> e + ",").collect(Collectors.joining()));
    }
}
