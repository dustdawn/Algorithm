package com.dustdawn.leetcode.dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 * @author dustdawn
 * @date 2022/5/26 21:29
 */
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        /**
         * 2.dp数组含义：dp[i]表示以nums[i]结尾的最长递增子序列
         */
        int[] dp = new int[nums.length];
        /**
         * 1.base case 至少包含本身
         */
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * 3.状态转移方程
                 */
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [10,9,2,5,3,7,101,18]
         * 输出：4
         * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
         * 示例 2：
         *
         * 输入：nums = [0,1,0,3,2,3]
         * 输出：4
         * 示例 3：
         *
         * 输入：nums = [7,7,7,7,7,7,7]
         * 输出：1
         */
    }
}
