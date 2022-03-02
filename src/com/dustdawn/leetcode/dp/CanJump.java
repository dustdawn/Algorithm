package com.dustdawn.leetcode.dp;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * @author dustdawn
 * @date 2022/3/2 21:19
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        /**
         * I.动态规划
         */
        // /**
        //  * 2.dp数组含义：dp[i]是否能到达下标为i的元素位置
        //  */
        // boolean[] dp = new boolean[nums.length];
        // /**
        //  * 1.base case
        //  */
        // // 第一个位置可以到达
        // dp[0] = true;
        // for (int i = 1; i < nums.length; i++) {
        //     // 从第j（j < i）个位置是否能到达i，只要第j个位置的步数值大于j到i的距离即可
        //     // 因为是从0位置出发，即只要能从第j个位置到达第i个位置，又能保证能到达第j个位置，就能到达第i个位置
        //     for (int j = 0; j < i; j++) {
        //         if (dp[j] && i - j <= nums[j]) {
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return dp[nums.length - 1];
        /**
         * II.贪心
         */
        // 每个元素能到达的最大范围，求并集的最大长度，如大于length - 1，说明能从下标为0的位置到达下标为1的位置
        if (nums.length == 1) {
            return true;
        }
        int maxRange = nums[0];
        // 如果走到一个下标，此时的最大范围没有更新到大于当前下标序号，说明不能到达当前位置
        for (int i = 0; i <= maxRange; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);
            if (maxRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [2,3,1,1,4]
         * 输出：true
         * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
         * 示例 2：
         *
         * 输入：nums = [3,2,1,0,4]
         * 输出：false
         * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
         */
    }
}
