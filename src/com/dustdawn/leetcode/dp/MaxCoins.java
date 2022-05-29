package com.dustdawn.leetcode.dp;

/**
 * 312. 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 *
 * @author dustdawn
 * @date 2022/5/26 21:41
 */
public class MaxCoins {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        // 加入边界两边加入虚拟气球，分数为1
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            points[i] = nums[i - 1];
        }
        /**
         * 2.dp数组：dp[i][j]表示戳破气球i到气球j之间可获得的最大分数
         */
        int[][] dp = new int[n + 2][n + 2];
        /**
         * 1.base case
         * dp[n][n]均为0
         */
        // 从下到上，从左到右遍历
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                /**
                 * 3.状态转移方程
                 * 假设k为戳破i和j中所有气球获得最高分数中最后一个戳破的气球
                 * 戳破k的得分为题干中公式，此时k旁边相邻的气球就是i和j
                 */
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         * 输入：nums = [3,1,5,8]
         * 输出：167
         * 解释：
         * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
         * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
         * 示例 2：
         *
         * 输入：nums = [1,5]
         * 输出：10
         */
    }
}
