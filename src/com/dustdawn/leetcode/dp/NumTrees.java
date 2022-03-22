package com.dustdawn.leetcode.dp;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 (即前序遍历为1到n)有多少种？
 * 返回满足题意的二叉搜索树的种数。
 * 提示：
 * 1 <= n <= 19
 *
 * @author dustdawn
 * @date 2022/3/22 19:22
 */
public class NumTrees {
    public static int numTrees(int n) {
        /**
         * 2.dp数组：dp[i,j]表示以i为底，长度为j的二叉搜索数的种数
         * 由1到j组成的长度为j的二叉搜索树的总数G[j]即为dp[1][j] + dp[2][j] + dp[3][j] + ...
         * 又因为dp[i][j] = G[i - 1]*G[j - i]（左子二叉搜索树和右子二叉搜索树的笛卡尔积）
         * 如dp[3][7] = 以3为底，长度为7的二叉搜索数的种数，左子二叉搜索树为1..2，右子二叉搜索树为4..7
         * 左子二叉搜索树种数为G[2]，右子二叉搜索树种树为G[4]。满足dp[3][7] = G[2] * G[4]
         * G[j] = G[2 - 1]*G[j - 2] + G[3 - 1]*G[j - 3] + G[4 - 1]*G[4 - 2] + ...（j大于2时，才有可能存在左右子二叉搜索树）
         */
        int[] G = new int[n + 1];
        /**
         * 1.base case
         */
        // 长度为0（空树）
        G[0] = 1;
        // 长度为1（只有根）
        G[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        /**.
         * 示例 1：
         *
         *
         * 输入：n = 3
         * 输出：5
         * 示例 2：
         *
         * 输入：n = 1
         * 输出：1
         */
    }
}
