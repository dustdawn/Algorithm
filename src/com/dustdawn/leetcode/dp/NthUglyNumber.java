package com.dustdawn.leetcode.dp;

/**
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3、5 的正整数。
 * 提示：
 * 1 <= n <= 1690
 *
 * @author dustdawn
 * @date 2022/3/22 18:26
 */
public class NthUglyNumber {
    public static int nthUglyNumber(int n) {
        int index_2 = 1;
        int index_3 = 1;
        int index_5 = 1;
        /**
         * 2.dp数组：dp[i]表示第i个丑数
         * 丑数都为2、3、5与之前丑数相乘的结果，比较他们各自与同一丑数的乘积进行排序，获得一定数量的丑数
         */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int num2 = 2 * dp[index_2];
            int num3 = 3 * dp[index_3];
            int num5 = 5 * dp[index_5];
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                index_2++;
            }
            if (dp[i] == num3) {
                index_3++;
            }
            if (dp[i] == num5) {
                index_5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：n = 10
         * 输出：12
         * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
         * 示例 2：
         *
         * 输入：n = 1
         * 输出：1
         * 解释：1 通常被视为丑数。
         */
        // 1 , 2, 3, 4, 5, 6, 8, 9, 10, 12，15，25
        System.out.println(nthUglyNumber(12));
    }
}
