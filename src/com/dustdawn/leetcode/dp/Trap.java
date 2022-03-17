package com.dustdawn.leetcode.dp;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * 通过次数424,985提交次数707
 *
 * @author dustdawn
 * @date 2022/3/17 21:53
 */
public class Trap {
    public static int trap(int[] height) {
        int n = height.length;
        int total = 0;
        // 从左向右遍历数组找到每个位置柱子达到的正向最高高度
        // 从有向左遍历数组找到每个位置柱子达到的反向最高高度
        // 获得的两组最高高度取最小值减去离地面的距离，即为雨水的容量高度（木桶效应）
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            dpLeft[i] = Math.max(maxHeight, height[i]);
            maxHeight = dpLeft[i];
        }
        maxHeight = 0;
        for (int i = n - 1; i >= 0; i--) {
            dpRight[i] = Math.max(maxHeight, height[i]);
            maxHeight = dpRight[i];
        }
        for (int i = 0; i < n; i++) {
            total += Math.min(dpLeft[i], dpRight[i]) - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
         * 输出：6
         * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水。
         * 示例 2：
         *
         * 输入：height = [4,2,0,3,2,5]
         * 输出：9
         */
    }
}
