package com.gilbert;

// f(1) = 1
// f(2) = 2
// f(n) =  f(n - 1) + f(n -2)
// 爬楼梯算法
public class ClimbStairs {
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        int methods = 1;
        for (int i = 2; i <= n; i ++) {
            methods = first + second;
            first = second;
            second = methods;
        }
        return methods;
    }

    public static void main(String[] argv) {
        System.out.println(new ClimbStairs().climbStairs(5));
    }
}
