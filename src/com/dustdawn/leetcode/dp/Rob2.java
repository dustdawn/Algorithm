package com.dustdawn.leetcode.dp;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * @author dustdawn
 * @date 2022/2/28 20:15
 */
public class Rob2 {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 环形首尾不能同时取，分为三种情况
        // 1.取0到n-1的数组 2.取1到n的数组 3.头尾都不要取1到n-1的数组
        // 即最高金额为三种情况的最大值。但由于金额为非负整数，长度越长的数组，最后的金额越高。即讨论一二场景的最高金额即可
        return Math.max(robRangeMax(nums, 0, nums.length - 2), robRangeMax(nums, 1, nums.length - 1));
    }

    /**
     * 同rob解法，限定起始点
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int robRangeMax(int[] nums, int left, int right) {
        int a = nums[left];
        int b = Math.max(nums[left], nums[left + 1]);
        int temp;
        for (int i = left + 2; i <= right; i++) {
            temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [2,3,2]
         * 输出：3
         * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
         * 示例 2：
         *
         * 输入：nums = [1,2,3,1]
         * 输出：4
         * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
         *      偷窃到的最高金额 = 1 + 3 = 4 。
         * 示例 3：
         *
         * 输入：nums = [1,2,3]
         * 输出：3
         */
    }
}
