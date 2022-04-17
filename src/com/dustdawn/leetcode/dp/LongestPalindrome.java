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
        /**
         * 1.base case
         */
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int begin = 0;
        int maxlength = 1;

        /**
         * 2.dp数组含义：dp[i][j]为i到j是否为回文串
         */
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

                /**
                 * 3.状态转移方程
                 */
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

    /**
     * 非动态规划解法
     * 时间复杂度O(N^2)同动态规划，空间复杂度O(1)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 找到长度为奇数的回文子串
            String s1 = palindrome(s, i, i);
            // 找到长度为偶数的回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 从s[l]和s[r]开始向两端扩散，返回以s[l]和s[r]为中心的最长回文串
     *
     * @param s
     * @param l
     * @param r
     */
    private static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome2("aacabdbacaa"));
        System.out.println(longestPalindrome("aacabbacaa"));
        System.out.println(longestPalindrome2("aacabbacaa"));
    }
}
