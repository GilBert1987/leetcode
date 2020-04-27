package com.gilbert.algo.dp;

// 70. 爬楼梯
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//        注意：给定 n 是一个正整数。
//
//        示例 1：
//
//        输入： 2
//        输出： 2
//        解释： 有两种方法可以爬到楼顶。
//        1.  1 阶 + 1 阶
//        2.  2 阶
//        示例 2：
//
//        输入： 3
//        输出： 3
//        解释： 有三种方法可以爬到楼顶。
//        1.  1 阶 + 1 阶 + 1 阶
//        2.  1 阶 + 2 阶
//        3.  2 阶 + 1 阶
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

    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //
    //        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    //
    //        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //
    //         
    //
    //        示例 1:
    //
    //        输入: [7,1,5,3,6,4]
    //        输出: 7
    //        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    //             随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    //        示例 2:
    //
    //        输入: [1,2,3,4,5]
    //        输出: 4
    //        解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    //             注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
    //             因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
    //        示例 3:
    //
    //        输入: [7,6,4,3,1]
    //        输出: 0
    //        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
    //
    //        来源：力扣（LeetCode）
    //        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
    //        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static class MaxProfit {
        public int maxProfit(int [] prices) {
            if (prices == null || prices.length == 1) {
                return 0;
            }

            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                maxProfit += prices[i] - prices[i -1] > 0 ? prices[i] - prices[i -1] : 0;
            }
            return maxProfit;
        }

        public static void main(String[] argv) {
            System.out.println(new MaxProfit().maxProfit(new int[] {7,1,5,3,6,4}));
            System.out.println(new MaxProfit().maxProfit(new int[] {1,2,3,4,5}));
        }
    }
}
