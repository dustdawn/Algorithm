package com.dustdawn.leetcode.ability;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * @author dustdawn
 * @date 2022/6/13 20:09
 */
public class SubarraySum {
    /**
     * 前缀和
     */
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组，preSum[i]代表nums[0..i]的子数组之和
        // int[] preSum = new int[n + 1];
        // 额外记录前缀和出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);
        int ans = 0;
        // nums[0..i]的前缀和
        int sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 目标前缀和
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                ans += preSum.get(sum0_j);
            }
            if (preSum.containsKey(sum0_i)) {
                preSum.put(sum0_i, preSum.get(sum0_i) + 1);
            } else {
                preSum.put(sum0_i, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [1,1,1], k = 2
         * 输出：2
         * 示例 2：
         *
         * 输入：nums = [1,2,3], k = 3
         * 输出：2
         */
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }
}
