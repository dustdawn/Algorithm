package com.dustdawn.leetcode.dp;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * 「回文串」是正读和反读都相同的字符串。
 * 提示：
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 *
 * @author dustdawn
 * @date 2022/5/15 12:21
 */
public class MinInsertions {
    public static int minInsertions(String s) {
        /**
         * 1.dp数组：dp[i][j]表示对于字符串s[i..j]成为回文串的最少插入次数
         */
        int[][] dp = new int[s.length()][s.length()];
        /**
         * 2.base case
         * i == j时，s[i][j]为单个字符，dp[i][j] = 0
         * 由状态方程可知，遍历顺序可由从左往右，从下往上取得dp[0][length - 1]
         * dp[length - 1][length - 1] = 0
         */
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                /**
                 * 3.状态转移方程
                 */
                // 左右字符相等时，等于左右前移的结果
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // 做选择，比较使得s[i + 1][j]和s[i][j - 1]变成回文串的最少操作次数
                    // 在已知dp[i + 1][j - 1]时，s[i + 1][j]和s[i][j - 1]变成最小回文都至少需要进行一次插入操作
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：s = "zzazz"
         * 输出：0
         * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
         * 示例 2：
         *
         * 输入：s = "mbadm"
         * 输出：2
         * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
         * 示例 3：
         *
         * 输入：s = "leetcode"
         * 输出：5
         * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
         */
    }
}
