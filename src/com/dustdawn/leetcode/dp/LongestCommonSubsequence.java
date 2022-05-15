package com.dustdawn.leetcode.dp;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）
 * 后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 提示：
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 *
 * @author dustdawn
 * @date 2022/5/15 11:12
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        /**
         * 1.base case
         * i或j为0时，两个字符串有一为空串，最长公共子序列长度为0
         *    '' a b c d e
         * ''
         * a
         * b
         * c
         */
        /**
         * 2.dp数组含义：dp[i][j]为text1[0, i - 1]到text2[0, j - 1]的最长公共子序列
         * 初始化长度为length + 1
         */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                /**
                 * 3.状态转移方程
                 */
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 当前字符在lcs中
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 至少有一个字符不在lcs，判断谁能让lcs最长
                    // dp[i-1][j-1]长度会最小，不可能比这两者大
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：text1 = "abcde", text2 = "ace"
         * 输出：3
         * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
         * 示例 2：
         *
         * 输入：text1 = "abc", text2 = "abc"
         * 输出：3
         * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
         * 示例 3：
         *
         * 输入：text1 = "abc", text2 = "def"
         * 输出：0
         * 解释：两个字符串没有公共子序列，返回 0 。
         */
    }
}
