package com.gilbert;

public class OddAndEvenSort {
    public int[] sort(int [] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        int [] ret = new int[nums.length];
        int p = 0; // 第一个偶数
        int q = nums.length - 1; // 最后一个奇数
        int x = 0;
        if(q % 2 == 0) {
            q = q - 1;
        }
    while(p < nums.length -1 && q > 0) {
        if(nums[p] < nums[q]) {
            ret[x++] = nums[p];
            p = p + 2;
        } else {
            ret[x++] = nums[q];
            q = q - 2;
        }
    }
    while(p < nums.length -1) {
        ret[x++] = nums[p];
        p = p + 2;
    }
    while(q > 0) {
        ret[x++] = nums[q];
        q = q - 2;
    }
    return ret;
}

public static void main(String[] argv) {
        System.out.println(new OddAndEvenSort().sort(new int[] {1, 200, 10, 120, 30, 8, 88, 4}));
}

}
