package com.dustdawn.leetcode.dp;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author dustdawn
 * @date 2022/2/21 20:46
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int begin = 0;
        int maxlength = 1;
        // dp[i][j] = i到j是否为回文串
        for (int i = 0; i < n; i++) {
            // i=j时为长度为1的回文串
            dp[i][i] = true;
        }
        // len为枚举的长度从2开始
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                // 右边界索引为i + len - 1
                int j = i + len - 1;
                // 越界
                if (j >= n) {
                    break;
                }

                if (str[i] == str[j]) {
                    // str[i][j]相等时，dp[i][j]是否为回文串取决于dp[i+1][j-1]是否为回文串
                    // 边界条件：i+1到j-1的距离为1时默认为回文串，即重合
                    if ((j - 1) - (i + 1) + 1 <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        // dp[i+1][j]和dp[i][j-1]的值分别在i循环后和len改变时计算到
                    }
                } else {
                    // 左右字符不相等返回false
                    dp[i][j] = false;
                }
                // i到j为回文串时，且长度大于最大长度
                if (dp[i][j] && (j - i + 1) > maxlength) {
                    maxlength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlength);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
