package com.dustdawn.leetcode.dp;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 * 提示:
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 *
 * @author dustdawn
 * @date 2022/3/7 21:27
 */
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        /**
         * I.动态规划
         */
        // int n = nums.length;
        // /**
        //  * 2.dp数组：dp[i]表示nums[0..j]中非空连续子数组的最大乘积
        //  * 与负数相乘可能会变成最大值，也可能会变成最小值，都记录到dp中
        //  */
        // int[] dpMax = new int[n];
        // int[] dpMin = new int[n];
        // /**
        //  * 1.base case
        //  */
        // int res = nums[0];
        // dpMax[0] = nums[0];
        // dpMin[0] = nums[0];
        // for (int i = 1; i < n; i++) {
        //     /**
        //      * 3.状态方程
        //      */
        //     // 最大乘积有三种情况：
        //     // 单独取nums[i]（nums[i]为0或nums[i]为正数，前一个序列元素为负数），或最小值*nums[i]（均为负数），或最大值*nums[i]（均为正数）
        //     dpMax[i] = Math.max(nums[i], Math.max(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
        //     // 最小乘积有三种情况：
        //     // 单独取nums[i]（nums[i]为0或nums[i]为负数，前一个序列元素也为负数），或最小值*nums[i]（nums[i]为正数），或最大值*nums[i]（nums[i]为负数）
        //     dpMin[i] = Math.min(nums[i], Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
        //     res = Math.max(res, dpMax[i]);
        // }
        /**
         * II.状态压缩
         * dp[i]只与dp[i-1]有关
         */
        int n = nums.length;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        int maxTemp;
        int minTemp;
        for (int i = 1; i < n; i++) {
            maxTemp = max;
            minTemp = min;
            max = Math.max(nums[i], Math.max(minTemp * nums[i], maxTemp * nums[i]));
            min = Math.min(nums[i], Math.min(minTemp * nums[i], maxTemp * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: nums = [2,3,-2,4]
         * 输出: 6
         * 解释: 子数组 [2,3] 有最大乘积 6。
         * 示例 2:
         *
         * 输入: nums = [-2,0,-1]
         * 输出: 0
         * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
         */
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }
}

