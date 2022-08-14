package com.dustdawn.leetcode.dp;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * @author dustdawn
 * @date 2022/5/29 16:39
 */
public class CanPartition {
    /**
     * 子集背包问题
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 和为奇数时，不可能划分两个和相等的集合
        if (sum % 2 == 1) {
            return false;
        }
        // 对半取
        sum = sum / 2;
        /**
         * 2.dp数组：dp[i][j]表示，只使用前i个物品，当背包容量为j时，是否可以恰好装满背包，最终结果即为dp[length][sum/2]
         */
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        /**
         * 1.base case
         * dp[...][0] = true：背包没有空间，相当于装满了
         * dp[0][...] = false：没有物品可选择时，肯定没办法装满背包
         */
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                /**
                 * 3.状态转移方程
                 * 不把第i个物品装入背包，是否能恰好装满取决于上一个状态dp[i - 1][j]，继承之前结果
                 * 把第i个物品装入背包，是否能够恰好装满背包取决于状态dp[i - 1][j - nums[i - 1]]
                 * (注：i是从1开始，数组索引从0开始，第i个物品的重量为nums[i - 1])
                 */
                if (j - nums[i - 1] < 0) {
                    // j不足，不能选择i
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 可以满足，不选择或选择
                    // dp[i - 1][j - nums[i - 1]]表示如果选择了第i个元素，判断nums[0..i-1]是否能凑成j - nums[i - 1]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    /**
     * 状态压缩
     *
     * @param nums
     * @return
     */
    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 和为奇数时，不可能划分两个和相等的集合
        if (sum % 2 == 1) {
            return false;
        }
        // 对半取
        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        // 压缩后i只作为次数，即nums.length次
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [1,5,11,5]
         * 输出：true
         * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
         * 示例 2：
         *
         * 输入：nums = [1,2,3,5]
         * 输出：false
         * 解释：数组不能分割成两个元素和相等的子集。
         */
    }
}
