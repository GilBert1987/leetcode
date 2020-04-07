package com.gilbert;

// LK 121 买卖股票的最佳时机
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//        如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
//        注意：你不能在买入股票前卖出股票。
// [7,1,5,3,6,4]
// 5
//输入: [7,6,4,3,1]
//        输出: 0
//        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
public class MaxProfile {
    public static int maxProfile(int [] prices) {
        if (prices == null || prices.length == 0  ) {
            return 0;
        }
        int minPrize = prices[0];
        int maxPro = 0;
        for (int i = 1; i< prices.length; i ++) {
            int profile = prices[i] - minPrize;
            if (profile < 0) {
                profile = 0;
                minPrize = prices[i];
            }
            maxPro = Math.max(profile, maxPro);
        }
        return maxPro;
    }

    public static void main(String[] a) {
        System.out.println(maxProfile(new int[] {7,1,5,3,6,4}));
    }
}
