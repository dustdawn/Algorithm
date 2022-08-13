package com.dustdawn.leetcode.dfs;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 黑白棋
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * @author dustdawn
 * @date 2022/5/15 11:48
 */
public class Solve {

    public static void solve(char[][] board) {
        // 循环棋盘的四边，用DFS算法找出与边界相连的0，替换成特殊字符，再把其他0替换为X，最后还原#
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // 把第一列和最后一列的0替换成#
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        // 把第一行和最后一行的0替换成#
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        // 剩下的0都可以替换成X
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        // 还原0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 深度优先将边界处的0即board[i][j]替换成#
     *
     * @param board
     * @param i
     * @param j
     */
    public static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            // 越界处理
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        // 进行替换
        board[i][j] = '#';
        // 向四周DFS搜索
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }


    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
         * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
         * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
         * 示例 2：
         *
         * 输入：board = [["X"]]
         * 输出：[["X"]]
         */
    }
}
