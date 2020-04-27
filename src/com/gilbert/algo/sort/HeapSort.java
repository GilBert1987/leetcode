package com.gilbert.algo.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int [] array = {30, 40, 70, 10};
        sort(array);

        Arrays.stream(array).forEach(e  -> {
            System.out.println(e);
        });
    }

    public static void sort(int [] array, int N) {
        /**
         * 构建大顶堆，首先进行自底向上的构建
         */
        for (int i = array.length / 2; i >=0; i--) {
            adjustHeap(array, i, array.length);
        }

        /**
         * 交换元素
         */
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
    }

    public static void buildHeap(int []arr) {
        /**
         * 构建大顶堆，首先进行自底向上的构建
         */
        for (int i = arr.length / 2; i >=0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }


    public static void sort(int [] array) {
        buildHeap(array);
        /**
         * 交换元素
         */
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
    }

    /**
     * 一次调整 将已元素i 为根的数组调整为大顶堆
     */
    public static void adjustHeap(int[] array , int i, int n) {
        int childIndex = 0;
        int father = 0;
        for (father = array[i]; getLeftChild(i) < n; i = childIndex) {
            childIndex = getLeftChild(i);
            if (childIndex != n -1 && array[childIndex] < array[childIndex +1]) {
                childIndex++;
            }
            if (father < array[childIndex]) {
                array[i] = array[childIndex];
            } else {
                break;
            }
        }
        array[i] = father;
    }

    private static int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
