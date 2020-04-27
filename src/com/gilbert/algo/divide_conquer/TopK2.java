package com.gilbert.algo.divide_conquer;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/

/**
 * 最小的K 个数，快速排序
 */
public class TopK2 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        return quickSort(arr, 0, arr.length - 1, k -1);
    }

    private int[] quickSort(int [] nums, int low, int high, int k) {
        int j = partition(nums, low, high);
        if (j == k) {
            return Arrays.copyOf(nums, k + 1);
        }
        return j > k ? quickSort(nums, low, j -1, k) : quickSort(nums, j +1 , high, k);
    }

    // 1 23456
    private int partition(int [] nums, int low, int high) {
        int target = nums[low];
        int i = low;
        int j = high + 1;
        while (i < j) {
            while (++i < j && nums[i] < target);
            while (--j > low && nums[j] > target);
            if (i >= j) {
                break;
            }
            swapPosition(nums, i, j);
        }
        // j 指向的是第一个比target 小的元素，因为 分割元素在最左边，所以 分割元素和J 进行替换，J 作为
        nums[low] = nums[j];
        nums[j] = target;
        return j;
    }

    private void swapPosition(int[]  nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public static void main(String[] argv) {
//        int [] array = new TopK2().getLeastNumbers(new int[]{8,6,5,2,9,1}, 2);
//        System.out.println(Arrays.stream(array).mapToObj(e -> e + ",").collect(Collectors.joining()));
        int [] array2 = new TopK2().getLeastNumbers(new int[]{5,1,2,3,4}, 2);
        System.out.println(Arrays.stream(array2).mapToObj(e -> e + ",").collect(Collectors.joining()));

    }
}
