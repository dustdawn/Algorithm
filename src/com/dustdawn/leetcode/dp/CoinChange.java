package com.dustdawn.leetcode.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * @author dustdawn
 * @date 2022/5/29 13:41
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        /**
         * 2.dp数组：dp[i]表示凑成i所需的最少硬币个数
         */
        int[] dp = new int[amount + 1];
        /**
         * 1.base case
         * dp[i]最大不超过amount，为求min设置为最大值
         * dp[0]不需要凑硬币，值为0
         */
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    /**
                     * 3.状态转移方程
                     * dp[i]取最少个数情况，不取当前coin或取当前coin
                     */
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        // dp[amount]值未改变，无法凑出amount金额的硬币情况
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：coins = [1, 2, 5], amount = 11
         * 输出：3
         * 解释：11 = 5 + 5 + 1
         * 示例 2：
         *
         * 输入：coins = [2], amount = 3
         * 输出：-1
         * 示例 3：
         *
         * 输入：coins = [1], amount = 0
         * 输出：0
         */
    }
}
