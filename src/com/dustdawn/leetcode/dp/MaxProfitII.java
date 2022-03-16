package com.dustdawn.leetcode.dp;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * 提示：
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 *
 * @author dustdawn
 * @date 2022/3/12 14:29
 */
public class MaxProfitII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        /**
         * I.直接统计升值（贪心）
         */
        // for (int i = 1; i < prices.length; i++) {
        //     if (prices[i] > prices[i - 1]) {
        //         maxProfit += prices[i] - prices[i - 1];
        //     }
        // }
        // return maxProfit;
        /**
         * II.动态规划
         */
        /**
         * 2.dp数组：dp[i][0]表示第i天手中无股票的最大利润，dp[i][1]表示第i天手中有股票的最大利润
         */
        int[][] dp = new int[prices.length][2];
        /**
         * 1.base case
         */
        // 第一天无股票，利润为0
        dp[0][0] = 0;
        // 第一天有股票，说明花费price[0]购买
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            /**
             * III.状态转移方程
             */
            // 第i天手中无股票情况可为第i天卖出和非第i天卖出
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            // 第i天手中有股票情况可为第i天买进和非第i天买进
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: prices = [7,1,5,3,6,4]
         * 输出: 7
         * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
         * 示例 2:
         *
         * 输入: prices = [1,2,3,4,5]
         * 输出: 4
         * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
         * 示例 3:
         *
         * 输入: prices = [7,6,4,3,1]
         * 输出: 0
         * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
         */
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
