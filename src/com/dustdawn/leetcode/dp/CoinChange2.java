package com.dustdawn.leetcode.dp;

/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 * 提示：
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 *
 * @author dustdawn
 * @date 2022/6/8 20:19
 */
public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        /**
         * 2.dp数组：dp[i]表示凑成i的硬币组合数
         */
        int[] dp = new int[amount + 1];
        /**
         * 1.base case
         * dp[0]为抽成0元的组合数，为一种即不选取硬币
         */
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                /**
                 * 3.状态转移方程
                 * 已知凑成金额之和i-coin的组合数时，加上coin即为凑成为金额i的组合数
                 * 因此需要遍历coins，对于其中的每一种面额的硬币，更新数组dp中的每个大于或等于该面额的元素的值
                 * 每次遍历coin顺序相同，保证不重复
                 */
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        /**
         *示例 1：
         *
         * 输入：amount = 5, coins = [1, 2, 5]
         * 输出：4
         * 解释：有四种方式可以凑成总金额：
         * 5=5
         * 5=2+2+1
         * 5=2+1+1+1
         * 5=1+1+1+1+1
         * 示例 2：
         *
         * 输入：amount = 3, coins = [2]
         * 输出：0
         * 解释：只用面额 2 的硬币不能凑成总金额 3 。
         * 示例 3：
         *
         * 输入：amount = 10, coins = [10]
         * 输出：1
         */
    }
}
