package com.gilbert.algo.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// LeetCode-40 最小的k个数
/**
 *  最小的K 个数，大顶堆
 */
public class GetLeastNumbers2 {

    public int[] getLestNumbers(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return new int[0];
        }
        // 优先级队列 默认是小顶堆，重写Comparator 改成大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                //构建大顶堆
                queue.offer(nums[i]);
            } else {
                int top = queue.peek();
                if(nums[i] < top) {
                    //数据比大顶堆小，更新大顶堆
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        int [] res = new int[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            res[idx++] = queue.poll();
        }
        return res;
    }

    public static void main(String[] argv) {
        int [] array = new GetLeastNumbers2().getLestNumbers(new int[]{8,6,5,2,9,1}, 2);
        System.out.println(Arrays.stream(array).mapToObj(e -> e + ",").collect(Collectors.joining()));
    }
}
