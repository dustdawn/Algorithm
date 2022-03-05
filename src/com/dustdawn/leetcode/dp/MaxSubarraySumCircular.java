package com.dustdawn.leetcode.dp;

/**
 * 918. 环形子数组的最大和
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * 环形数组 意味着数组的末端将会与开头相连呈环状。
 * 形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
 * 形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * 提示：
 * n == nums.length
 * 1 <= n <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 *
 * @author dustdawn
 * @date 2022/3/5 21:32
 */
public class MaxSubarraySumCircular {
    public static int maxSubarraySumCircular(int[] nums) {
        // 根据53. 最大子数组和MaxSubArray，找到最大和子数组在中间的情况值
        int length = nums.length;
        int a = nums[0];
        int b;
        int res = a;
        int res2 = 0;
        // 记录整个数组的和，当最大和子数组不在中间时，说明是首尾相连，数组中间不在最大和子数组中的必是负数
        int sum = nums[0];
        for (int i = 1; i < length; i++) {
            sum += nums[i];
            b = Math.max(nums[i], nums[i] + a);
            a = b;
            res = Math.max(res, b);
        }
        a = nums[0];
        // 为负数部门，首尾必不包含（0，length - 1）
        for (int i = 1; i < length - 1; i++) {
            b = Math.min(nums[i], nums[i] + a);
            a = b;
            res2 = Math.min(res2, b);
        }
        return Math.max(res, sum - res2);
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [1,-2,3,-2]
         * 输出：3
         * 解释：从子数组 [3] 得到最大和 3
         * 示例 2：
         *
         * 输入：nums = [5,-3,5]
         * 输出：10
         * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
         * 示例 3：
         *
         * 输入：nums = [3,-2,2,-3]
         * 输出：3
         * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
         */
    }
}
