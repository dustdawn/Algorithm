package com.dustdawn.leetcode.dp;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 提示：
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 *
 * @author dustdawn
 * @date 2022/3/16 21:34
 */
public class MaxProfitIIII {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        /**
         * I.动态规划
         */
        // /**
        //  * 2.dp数组：dp[i][0]表示第i天手中无股票的最大利润，dp[i][1]表示第i天手中有股票的最大利润
        //  */
        // int[][] dp = new int[n][2];
        // /**
        //  * 1.base case
        //  */
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0];
        // for (int i = 1; i < n; i++) {
        //     /**
        //      * 2.状态转移方程
        //      */
        //     // 第i天手中无股票情况可为非第i天卖出和第i天卖出
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
        //     // 第i天手中有股票情况可为非第i天买进第i天买进
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        // }
        // return dp[n - 1][0];
        /**
         * I.直接统计升值（贪心）
         */
        // 手续费放在买入时计算，和MaxProfit一样，升值的前一值需要算上fee
        int maxProfit = 0;
        // buy 表示在最大化收益的前提下，如果我们手上拥有一支股票，那么它的最低买入价格是多少
        int buy = prices[0] + fee;
        for (int i = 1; i < prices.length; i++) {
            // 当天的buy小于 当前 手里股票价格（加上手续费）即旧buy，根据buy的定义则可以更新buy
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                // 是盈利的，直接卖出股票收益
                maxProfit += prices[i] - buy;
                // 如果maxProfit不是最佳值，保存buy
                // 如果下一天继续盈利，maxProfit会加上等价于prices[i] - prices[i - 1]的值
                // 即prices[i-1] - prices[i - 2] += prices[i] - prices[i - 1];
                // 此时maxProfit等价于prices[i] - prices[i - 2]，即第i-1天无操作，和第i-2天买入和第i天卖出是等价的
                // 能保证maxProfit最终为最大总收益
                buy = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        /**
         *示例 1：
         *
         * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
         * 输出：8
         * 解释：能够达到的最大利润:
         * 在此处买入 prices[0] = 1
         * 在此处卖出 prices[3] = 8
         * 在此处买入 prices[4] = 4
         * 在此处卖出 prices[5] = 9
         * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
         * 示例 2：
         *
         * 输入：prices = [1,3,7,5,10,3], fee = 3
         * 输出：6
         */
    }
}
