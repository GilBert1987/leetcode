package com.gilbert;

/**
 * 一个数组先递增，后递减 求最大数
 */
public class GetMaxPointInArray {

    public static int getMagicNunberIndex(int [] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return 0;
        }
        /**
         * 单调递减
         */
        if (array[0] > array[1]) {
            return 0;
        }
        /**
         * 单调递增
         */
        if (array[array.length - 1] > array[array.length -2]) {
            return array[array.length - 1];
        }
        int start = 0; int end = array.length - 1;
        while (start < end) {
            int mid = (start + end) / 2; // 5+ 8 / 2
            int isMagic = isMagicNumber(array, mid);
            if (isMagic == 0) {
                return mid;
            } else if (isMagic == 1) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }

    /**
     * return 0 是
     * return 1， Magic 比 index 大
     * return -1 Magic 比 idex 小
     */
    private static int isMagicNumber(int[] array, int index) {
        if (array[index] > array[index - 1] && array[index] > array[index + 1]) {
            return 0;
        } else if (array[index] > array[index - 1]){
            return 1;
        }
        return -1;
    }

    public static void main(String [] arg) {
        System.out.println(getMagicNunberIndex(new int[] {1, 3,5,7,3}));
    }
}
