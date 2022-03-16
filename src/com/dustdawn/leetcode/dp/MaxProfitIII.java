package com.dustdawn.leetcode.dp;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 提示：
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 * @author dustdawn
 * @date 2022/3/14 20:47
 */
public class MaxProfitIII {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        /**
         * II.dp数组含义：dp[i][0,1,2]代表第i天
         * 手中持有股票、手中不持有股票且不处于冷冻期、手中不持有股票且处于冷冻期
         * 三种情况的最大收益
         */
        int[][] dp = new int[n][3];
        /**
         * I.base case
         */
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            /**
             * III.状态转移方程
             */
            // 第i天持有股票，前一天不可能为不持有股票且处于冷冻期，否则违背条件，前一天两种情况：
            // 1.持有股票，则第i天收益不变
            // 2.不持有股票且不处于冷冻期，则第i天收益为减去买入当天股票价格后收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 第i天不持有股票且不处于冷冻期，前一天如果持有股票，则违背条件，前一天只有两种情况：
            // 1.不持有股票且不处于冷冻期，则第i天收益不变
            // 2.不持有股票且处于冷冻期，则第i天收益不变
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            // 第i天不持有股票且处于冷冻期，当前肯定卖出，则前一天只有持有股票一种情况：
            // 1.持有股票，则第i天要加上当天卖出股票的价格
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: prices = [1,2,3,0,2]
         * 输出: 3
         * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
         * 示例 2:
         *
         * 输入: prices = [1]
         * 输出: 0
         */
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
