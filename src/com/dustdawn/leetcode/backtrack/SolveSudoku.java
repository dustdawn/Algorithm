package com.dustdawn.leetcode.backtrack;

/**
 * 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 *
 * @author dustdawn
 * @date 2022/5/29 15:36
 */
public class SolveSudoku {
    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                backtrack(board, i, j);
            }
        }
    }

    /**
     * 对board[i][j]进行穷举尝试回溯
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    public static boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后一列，换到下一行重新开始
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // 穷举到了最后一行，说明找到一个可行解，触发base case
            return true;
        }
        if (board[i][j] != '.') {
            // 如果不为空白则有数字，不需要穷举，换到下一列
            return backtrack(board, i, j + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            // 做选择
            board[i][j] = ch;
            // 继续穷举下一位置。如果找到一个可行解，结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            // 撤销选择
            board[i][j] = '.';
        }
        // 穷举完1~9，依然没有找到可行解
        // 需要前面的格子换个数字穷举
        return false;
    }

    public static boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否重复
            if (board[r][i] == n) {
                return false;
            }
            // 判断列是否重复
            if (board[i][c] == n) {
                return false;
            }
            // 判断3x3方框中是否存在重复
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
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
         * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
         * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
         * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
         */
    }
}
