package com.dustdawn.leetcode.dp;

/**
 * 1567. 乘积为正数的最长子数组长度
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * 请你返回乘积为正数的最长子数组长度。
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * @author dustdawn
 * @date 2022/3/10 21:23
 */
public class GetMaxLen {
    public static int getMaxLen(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] > 0 ? 1 : 0;
        }
        /**
         * 2.dp数组：dpP[i]为包含nums[i]的乘积为正的最长子数组长度，dpN[i]为乘积为负的最长子数组长度
         */
        int[] dpP = new int[n];
        int[] dpN = new int[n];
        /**
         * 1.base case
         */
        dpP[0] = nums[0] > 0 ? 1 : 0;
        dpN[0] = nums[0] < 0 ? 1 : 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            // 变号时，只要dp[i - 1]存在，dpN则加一
            int temp = dpN[i - 1] > 0 ? (dpN[i - 1] + 1) : 0;
            if (nums[i] > 0) {
                // 为正数，包含nums[i]的乘积为正的最长子数组长度至少为1
                dpP[i] = dpP[i - 1] + 1;
                // 负数*正数=负数，只要dpN[i - 1]存在，dpN则在dpN[i - 1]基础上加一
                dpN[i] = temp;
            } else if (nums[i] < 0) {
                // 为负数，dpP和dpN的长度调换过来
                dpN[i] = dpP[i - 1] + 1;
                // 负数*负数=正数数，只要dp[i - 1]存在，dpP则在dpN[i - 1]基础上加一
                dpP[i] = temp;
            } else {
                // 为0，则包含nums[i]的最长子数组长度均为0
                dpP[i] = 0;
                dpN[i] = 0;
            }
            res = Math.max(res, dpP[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例  1：
         *
         * 输入：nums = [1,-2,-3,4]
         * 输出：4
         * 解释：数组本身乘积就是正数，值为 24 。
         * 示例 2：
         *
         * 输入：nums = [0,1,-2,-3,-4]
         * 输出：3
         * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
         * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
         * 示例 3：
         *
         * 输入：nums = [-1,-2,-3,0,1]
         * 输出：2
         * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
         */
        // 1异号
        System.out.println((1 ^ -1) >>> 31);
        // 0同号
        System.out.println((-1 ^ -1) >>> 31);
        // 0同号
        System.out.println((1 ^ 1) >>> 31);
        // 0同号
        System.out.println((1 ^ 0) >>> 31);
        // 1异号
        System.out.println((-1 ^ 0) >>> 31);
        // 0同号
        System.out.println((0 ^ 0) >>> 31);
    }
}
