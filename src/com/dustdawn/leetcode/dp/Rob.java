package com.dustdawn.leetcode.dp;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * @author dustdawn
 * @date 2022/2/28 19:49
 */
public class Rob {
    public static int rob(int[] nums) {
        /**
         * I.动态规划
         */
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // int n = nums.length;
        // if (n == 1) {
        //     return nums[0];
        // }
        // /**
        //  * 2.dp数组含义：dp[i]为抢到第i个房屋时偷窃到的最高金额，最终结果为dp[n - 1]
        //  */
        // int[] dp = new int[n];
        // /**
        //  * 1.base case
        //  */
        // // 到第一个房屋时最高金额为nums[0]
        // dp[0] = nums[0];
        // // 到第二个房屋时最高金额为选了第一间房屋或者选择当前房屋的情况时的最高金额
        // dp[1] = Math.max(nums[0], nums[1]);
        // for (int i = 2; i < n; i++) {
        //     /**
        //      * 3.状态转移方程
        //      */
        //     // 抢到第i个房屋时偷窃到的最高金额有两种情况
        //     // 1.选了上一间房屋，不选当前房屋（金额即为dp[i-1]）
        //     // 2.没选上一间房屋，可选当前房屋（金额即为dp[i-2]的金额加上当前房屋金额）
        //     dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        // }
        // return dp[n - 1];
        /**
         * II.优化
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int temp;
        for (int i = 2; i < n; i++) {
            temp = Math.max(b, a + nums[i]);
            a = b;
            b = temp;

        }
        return b;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：[1,2,3,1]
         * 输出：4
         * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
         *      偷窃到的最高金额 = 1 + 3 = 4 。
         * 示例 2：
         *
         * 输入：[2,7,9,3,1]
         * 输出：12
         * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
         *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
         */
    }
}
