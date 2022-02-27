package com.dustdawn.leetcode.dp;

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 提示：
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 *
 * @author dustdawn
 * @date 2022/2/27 15:43
 */
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        /**
         * I.动态规划
         */
        // int length = cost.length;
        // /**
        //  * 2.dp数组含义：dp[i]为走到下标为i的台阶时的最低花费
        //  */
        // int[] dp = new int[length + 1];
        // /**
        //  * 1.base case
        //  * 走到下标为1的台阶往后继续走，只有从0号台阶走一步的情况，花费cost[0]
        //  */
        // // 可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯，所以dp[1] = 0
        // dp[0] = 0;
        // dp[1] = 0;
        // for (int i = 2; i < dp.length; i++) {
        //     /**
        //      * 3.状态选择方程
        //      */
        //     dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        // }
        // // dp[length]即为最后一个台阶length-1号走到楼顶的花费
        // return dp[length];
        /**
         * II.优化解法
         */
        int a = 0;
        int b = 0;
        int temp;
        for (int i = 2; i < cost.length + 1; i++) {
            temp = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：cost = [10,15,20]
         * 输出：15
         * 解释：你将从下标为 1 的台阶开始。
         * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
         * 总花费为 15 。
         * 示例 2：
         *
         * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
         * 输出：6
         * 解释：你将从下标为 0 的台阶开始。
         * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
         * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
         * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
         * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
         * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
         * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
         * 总花费为 6 。
         */
    }
}
