package com.dustdawn.leetcode.dp;

/**
 * 413. 等差数列划分
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 * 提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 * @author dustdawn
 * @date 2022/3/21 18:55
 */
public class NumberOfArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] nums) {
        int total = 0;
        int n = nums.length;
        /**
         * I.暴力解法
         */
//        for (int i = 0; i < n - 2; i++) {
//            for (int j = i + 1; j < n - 1; j++) {
//                if (nums[j] - nums[j - 1] == nums[j + 1] - nums[j]) {
//                    total++;
//                } else {
//                    break;
//                }
//            }
//        }
        /**
         * II.动态规划
         */
        /**
         * 2.dp数组：dp[i]表示以nums[i]为结尾的等差子数组时，新增的等差子数组个数
         * 此时可以获得状态转移方程dp[i] = dp[i - 1] + 1
         * 如dp[i - 1]为1时的等差数组例为1,2,3，nums[i]如果为4，dp[i]为2（1,2,3,4和2,3,4）
         * 如dp[i - 1]为2时的等差数组例为1,2,3,4，nums[i]如果为5，dp[i]为3（1,2,3,4,5和2,3,4,5和3,4,5）
         * 统计总个数，只需要累加dp[i]即可
         */
        /**
         * 1.base case：前两项根据dp的定义为0
         */
        int temp = 0;
        for (int i = 2; i < n; i++) {
            // nums[i]是否能作为等差子数组结尾
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                /**
                 * 3.状态转移方程dp[i] = dp[i - 1] + 1
                 */
                temp++;
            } else {
                temp = 0;
            }
            total += temp;
        }
        return total;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [1,2,3,4]
         * 输出：3
         * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
         * 示例 2：
         *
         * 输入：nums = [1]
         * 输出：0
         */
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(numberOfArithmeticSlices(new int[]{1}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }
}
