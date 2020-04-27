package com.gilbert.algo.heap;

import com.gilbert.algo.sort.HeapSort;

import java.util.Arrays;

/**
 * 最小的K个数 大顶堆
 */
public class TopK {
    public static int[] getTopK(int[] array, int K) {
        if (K == 0) {
            return null;
        }
        if (array== null || array.length <= K) {
            return array;
        }
        int[] ret = new int[K];
        System.arraycopy(array, 0, ret, 0, K);

        // 建立大顶堆
        HeapSort.buildHeap(ret);
        for(int i = K; i < array.length; i++) {
            if (array[i] > ret[0]) {
                continue;
            }
            else {
                ret[0] = array[i];
                // adjust heap
                HeapSort.adjustHeap(ret, 0, ret.length);
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(ret).forEach(e ->sb.append(e + ","));

        System.out.println(sb.toString());
        return ret;
    }

    public static void main(String [] a) {
        getTopK(new int[] {2,4,6,8,1,-3,-6}, 2);
        getTopK(new int[] {2,4,6,8,1,-3,-6}, 1);
    }
}
