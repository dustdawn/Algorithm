package com.dustdawn.leetcode.dp;

/**
 * 1014. 最佳观光组合
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 * 提示：
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 *
 * @author dustdawn
 * @date 2022/3/12 13:16
 */
public class MaxScoreSightseeingPair {
    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int res = 0;
        /**
         * I.暴力解法
         */
        // int temp;
        // /**
        //  * 2.dp数组：dp[i][j]表示i到j的评分
        //  */
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int sum = values[i] + values[j];
        //         // 两景点之和小于距离差
        //         if (sum < j - i) {
        //             break;
        //         }
        //         /**
        //          * 3.状态方程
        //          */
        //         temp = sum + i - j;
        //         res = Math.max(res, temp);
        //     }
        // }
        // return res;
        /**
         * II.技巧解法
         * 公式转换：values[i] + values[j] + i - j
         * 由于遍历时，不管i为何值时，内层循环的value[j] - j的值都和上一轮的相同
         * 则可以去除内层循环，外层循环只统计values[i] + i的最大值
         */
        int max = values[0] + 0;
        for (int j = 1; j < n; j++) {
            res = Math.max(res, max + values[j] - j);
            // 此处相当于外层循环的values[i] + i
            max = Math.max(max, values[j] + j);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：values = [8,1,5,2,6]
         * 输出：11
         * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
         * 示例 2：
         *
         * 输入：values = [1,2]
         * 输出：2
         */
    }
}
