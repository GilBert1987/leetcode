package com.gilbert.algo.divide_conquer;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void sort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] arrar, int start, int end) {
        if(start < end) {
            int mid  = (start + end) /2;
            sort(arrar, start, mid);
            sort(arrar, mid + 1, end);
            merge(arrar, start, end, mid);
        }
    }

    private static void merge(int [] array, int left, int right, int mid) {
        int [] temp = new int[array.length];
        int p = left;
        int q = mid +1;
        int k = left;
        while (p <= mid && q <= right) {
            if(array[p] < array[q]) {
                temp[k++] = array[p++];
            } else {
                temp[k++] = array[q++];
            }
        }
        while (p <= mid) {
            temp[k++] = array[p++];
        }
        while (q <= right) {
            temp[k++] = array[q++];
        }

        for (int i = left; i <= right ; i++) {
            array[i] = temp[i];
        }
    }
    public static void main(String[] argv) {
        int [] array = new int[] {1,3,4,5,2,1};
        sort(array);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(array).forEach(e -> sb.append(e + ","));
        System.out.println(sb);
    }
}
