package com.dustdawn.leetcode.dp;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 提示:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 * @author dustdawn
 * @date 2022/3/2 22:24
 */
public class Jump {
    public static int jump(int[] nums) {
        // 初始化到达的边界元素序号
        int end = 0;
        // 跳跃次数
        int steps = 0;
        int maxRange = nums[0];
        // 只需要到达最后一个位置
        for (int i = 0; i < nums.length - 1; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);
            // 到达边界
            if (i == end) {
                end = maxRange;
                // 从[0..i]任意位置中跳能到达的最远距离为i，此步必跳
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: nums = [2,3,1,1,4]
         * 输出: 2
         * 解释: 跳到最后一个位置的最小跳跃数是 2。
         *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
         * 示例 2:
         *
         * 输入: nums = [2,3,0,1,4]
         * 输出: 2
         */
    }
}
