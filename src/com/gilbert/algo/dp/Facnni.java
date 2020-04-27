package com.gilbert.algo.dp;

// LeetCode-10- I. 斐波那契数列
/**
 * 斐波那契数列
 */
// f(n) = f(n-1) + f(n-2)
// f(0) = 1; f(1) = 1
public class Facnni {
    /**
     * 动态规划解法
     */
    public static int getStepNums(int n) {
        int first = 1, second = 1;
        int ret = 1;
        for (int i = 1; i < n; i++) {
            ret = first + second;
            first = second;
            second = ret;
        }
        return ret;
    }

    public static int getStepNums_2(int n) {
        if(n == 1) {
            return 1;
        }
        if (n == 0) {
            return 1;
        }
        return getStepNums_2(n -1) + getStepNums_2(n -2);
    }
    public static void main(String[]  ar) {
        System.out.println(getStepNums(5)); // 1, 1,2,3,5,8
        System.out.println(getStepNums_2(5));
    }
}
