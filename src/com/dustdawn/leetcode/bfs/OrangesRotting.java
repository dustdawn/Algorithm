package com.dustdawn.leetcode.bfs;

/**
 * 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * @author dustdawn
 * @date 2022/9/3 14:04
 */
public class OrangesRotting {

    public int orangesRotting(int[][] grid) {
        boolean flag = true;
        int row = grid.length;
        int col = grid[0].length;
        int min = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    /*
                    grid[i][j]值：
                    0 空单元
                    1 新鲜橘子
                    2 腐烂橘子（第0分钟腐烂的橘子）
                    3 第1分钟腐烂的橘子
                    4 第2分钟腐烂的橘子
                    min+2 第min分钟腐烂的橘子
                     */
                    // min分钟以及之前分钟，状态为腐烂的橘子
                    if (grid[i][j] >= 2 && grid[i][j] <= min + 2) {
                        // 四个有效方向内找到新鲜橘子扩散腐蚀，状态修改为下一分钟状态是腐蚀的橘子
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = min + 3;
                            flag = true;
                        }
                        if (i + 1 < row && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = min + 3;
                            flag = true;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = min + 3;
                            flag = true;
                        }
                        if (j + 1 < col && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = min + 3;
                            flag = true;
                        }
                    }
                }
            }
            min++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min - 1;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         *
         * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
         * 输出：4
         * 示例 2：
         *
         * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
         * 输出：-1
         * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
         * 示例 3：
         *
         * 输入：grid = [[0,2]]
         * 输出：0
         * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
         */
    }
}
