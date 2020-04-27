package com.gilbert.algo.heap;

//215. 数组中的第K个最大元素
//        在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        示例 1:
//
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//        示例 2:
//
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4
//        说明:
//
//        你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/

public class KthLargest {
    public static int getKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < k) {
            return 0;
        }
        buildHeap(nums);
        int ret = 0;
        int lastElemIndex = nums.length -1;
        for (int i = 0; i < k; i++) {
            /**
             * 将最后一个元素和第一个元素替换，调整堆
             */
            ret = nums[0];
            nums[0] = nums[lastElemIndex];
            adjust(nums, 0, lastElemIndex--);// 注意数组的大小需要调整
        }
        return ret;
    }

    /**
     * 建立大顶堆，从下向上进行调整
     */
    public static void buildHeap(int [] nums) {
        for (int i = nums.length/2 -1; i>=0; i--){
            adjust(nums, i, nums.length);
        }
    }

    /**
     * 将大小为size的数组nums 节点i为根的调整为大顶堆
     */
    public static void adjust(int [] nums, int i, int size) {
        int father = nums[i];
        int leftChildIndex = getLeftChild(i);
        while (leftChildIndex < size) {
            /**
             * 选择两个节点里面最大的一个节点
             */
            if(leftChildIndex != size -1 && nums[leftChildIndex] < nums[leftChildIndex + 1]) {
                leftChildIndex++;
            }
            if (nums[leftChildIndex] > father) {
                nums[i] = nums[leftChildIndex];
                i = leftChildIndex;
                leftChildIndex = getLeftChild(i);
            } else {
                break;
            }
        }
        nums[i] = father;
    }

    private static int getLeftChild(int i) {
        return 2 * i +1;
    }

    public static void main(String[]  ar) {
        System.out.println(getKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }
}
