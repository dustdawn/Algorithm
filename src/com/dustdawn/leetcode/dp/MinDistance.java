package com.dustdawn.leetcode.dp;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * @author dustdawn
 * @date 2022/6/16 20:52
 */
public class MinDistance {
    /**
     * 解决两个字符串的动态规划问题，一般用两个指针i,j分别指向两个字符串的最后。然后往前走缩小问题的规模
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        /**
         * 2.dp数组：dp[i][j]表示是s1[0..i]和s2[0..j]的最小编辑距离
         */
        int[][] dp = new int[m + 1][n + 1];
        /**
         * 1.base case
         * i走完word1或j走完word2
         */
        for (int i = 0; i < m + 1; i++) {
            // word2走完，编辑距离为删除字符次数
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            // word1走完，编辑距离为插入字符次数
            dp[0][j] = j;
        }
        /**
         * 3.状态转移方程
         * 选择：
         * 1.不动
         * 2.插入、替换或删除
         */
        // 最终接为dp[m][n]，从左往右、从上往下遍历
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 1.不动
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 2.三选一：替换、删除、插入都要进行一次操作则+1
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：word1 = "horse", word2 = "ros"
         * 输出：3
         * 解释：
         * horse -> rorse (将 'h' 替换为 'r')
         * rorse -> rose (删除 'r')
         * rose -> ros (删除 'e')
         * 示例 2：
         *
         * 输入：word1 = "intention", word2 = "execution"
         * 输出：5
         * 解释：
         * intention -> inention (删除 't')
         * inention -> enention (将 'i' 替换为 'e')
         * enention -> exention (将 'n' 替换为 'x')
         * exention -> exection (将 'n' 替换为 'c')
         * exection -> execution (插入 'u')
         */
    }
}
