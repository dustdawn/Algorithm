package com.dustdawn.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 提示：
 * 1 <= n <= 9
 *
 * @author dustdawn
 * @date 2022/6/6 20:56
 */
public class SolveNQueens {
    /**
     * 输入棋盘边长n，返回所有合法的放置方法
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            Arrays.fill(ch, '.');
            board[i] = new String(ch);
        }
        backtrack(res, board, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, String[] board, int row) {
        // 触发结束条件
        if (row == board.length) {
            res.add(Arrays.asList(Arrays.copyOf(board, board.length)));
            return;
        }
        int n = board[row].length();
        for (int col = 0; col < n; col++) {
            // 排查不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row] = board[row].substring(0, col) + 'Q' + board[row].substring(col + 1);
            // 进入下一次决策
            backtrack(res, board, row + 1);
            //撤销选择
            board[row] = board[row].substring(0, col) + '.' + board[row].substring(col + 1);
        }
    }

    /**
     * 检查冲突
     * 皇后是从上往下一行一行放置，所以只用检查正上方、左上方、右上方即可
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private static boolean isValid(String[] board, int row, int col) {
        int n = board.length;
        // 检查列中是否有皇后互相冲突
        for (int i = 0; i < row; i++) {
            if (board[i].charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查右上方中是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i].charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查左上方中是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i].charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：n = 4
         * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
         * 解释：如上图所示，4 皇后问题存在两个不同的解法。
         * 示例 2：
         *
         * 输入：n = 1
         * 输出：[["Q"]]
         */
        System.out.println(solveNQueens(4));
    }
}
