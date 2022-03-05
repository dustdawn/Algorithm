package com.dustdawn.leetcode.dp;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author dustdawn
 * @date 2022/3/5 21:07
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        /**
         * I.动态规划
         */
        // int length = nums.length;
        // /**
        //  * 2.dp数组：dp[i]表示以nums[i]结尾的最大子数组的和
        //  */
        // int[] dp = new int[length];
        // /**
        //  * 1.base case
        //  */
        // dp[0] = nums[0];
        // for (int i = 1; i < length; i++) {
        //     /**
        //      * 3.状态转移方程
        //      */
        //     // dp[i]有两种选择，以自己单独为子数组，或与前面相邻的子数组组成大的子数组
        //     dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        // }
        // int res = Integer.MIN_VALUE;
        // for (int i = 0; i < length; i++) {
        //     res = Math.max(res, dp[i]);
        // }
        // return res;
        /**
         * II.状态压缩
         * dp[i]只和dp[i-1]有关联
         */
        int length = nums.length;
        int a = nums[0];
        int b;
        int res = a;
        for (int i = 1; i < length; i++) {
            b = Math.max(nums[i], nums[i] + a);
            a = b;
            res = Math.max(res, b);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
         * 输出：6
         * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
         * 示例 2：
         *
         * 输入：nums = [1]
         * 输出：1
         * 示例 3：
         *
         * 输入：nums = [5,4,-1,7,8]
         * 输出：23
         */
    }
}
