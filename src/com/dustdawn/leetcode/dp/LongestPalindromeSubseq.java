package com.dustdawn.leetcode.dp;

/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * @author dustdawn
 * @date 2022/2/21 22:13
 */
public class LongestPalindromeSubseq {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        int[][] dp = new int[n][n];
        // dp[i][j] = i到j的最大回文长度值
        for (int i = 0; i < n; i++) {
            // i=j时长度为1
            dp[i][i] = 1;
        }
        /**
         * 1 - - - ?
         * 0 1 - - -
         * 0 0 1 - -
         * 0 0 0 1 -
         * 0 0 0 0 1
         */
        // 从dp[n-1][n-1]的上一行开始倒序遍历，即dp[n-2][n-1]
        for (int i = n - 2; i >= 0; i--) {
            // j方向从左往右遍历
            for (int j = i + 1; j < n; j++) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("a"));
        System.out.println(longestPalindromeSubseq("ac"));
        System.out.println(longestPalindromeSubseq("aacabdkacaa"));
    }
}
