package com.dustdawn.leetcode.dp;

/**
 * 931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * 提示：
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 *
 * @author dustdawn
 * @date 2022/3/24 21:03
 */
public class MinFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        // 确认倒数第二行到倒数第一行的选取，依次倒推到倒数第三行、倒数第四行即可
        // 如正向选取，不能保证因为选择了下面一行而导致下面两行以后的选取不是最佳方案
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int min = matrix[i + 1][j];
                if (j > 0) {
                    min = Math.min(min, matrix[i + 1][j - 1]);
                }
                if (j < n - 1) {
                    min = Math.min(min, matrix[i + 1][j + 1]);
                }
                matrix[i][j] += min;
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res, matrix[0][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
         * 输出：13
         * 解释：如图所示，为和最小的两条下降路径
         * 示例 2：
         *
         * 输入：matrix = [[-19,57],[-40,-5]]
         * 输出：-59
         * 解释：如图所示，为和最小的下降路径
         */
    }
}
