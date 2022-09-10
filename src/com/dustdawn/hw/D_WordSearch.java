package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 单词搜索（找到它）(200分)(dfs回溯扩散)
 * 题目描述
 * 找到它是一个小游戏，你需要在一个矩阵中找到给定的单词。
 * 假设给定单词 HELLOWORD，在矩阵中只要能找到 H->E->L->L->O->W->O->R->L->D连成的单词，就算通过。
 * 注意区分英文字母大小写，并且您只能上下左右行走，不能走回头路。
 * 输入描述
 * 输入第 1 行包含两个整数 n、m (0 < n,m < 21) 分别表示 n 行 m 列的矩阵，
 * 第 2 行是长度不超过100的单词 W (在整个矩阵中给定单词 W 只会出现一次)，
 * 从第 3 行到第 n+2 行是指包含大小写英文字母的长度为 m 的字符串矩阵。
 * 输出描述
 * 如果能在矩阵中连成给定的单词，则输出给定单词首字母在矩阵中的位置(第几行 第几列)，
 * 否则输出“NO”。
 *
 * @author dustdawn
 * @date 2022/9/4 21:02
 */
public class D_WordSearch {
    public static boolean find = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        String word = in.nextLine();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = in.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        // 回溯DFS
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(i, j, board, word, visited, 0);
                    if (find) {
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }

    public static void dfs(int i, int j, char[][] board, String word, boolean[][] visited, int pos) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || find || board[i][j] != word.charAt(pos)) {
            return;
        }
        if (pos == word.length() - 1) {
            find = true;
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, board, word, visited, pos + 1);
        dfs(i - 1, j, board, word, visited, pos + 1);
        dfs(i, j + 1, board, word, visited, pos + 1);
        dfs(i, j - 1, board, word, visited, pos + 1);
        visited[i][j] = false;
    }
    /**
     * 示例
     * 输入
     * 5 5
     * HELLOWORLD
     * CPUCY
     * EKLQH
     * CHELL
     * LROWO
     * DGRBC
     * 输出
     * 3 2
     * 输入
     * 5 5
     * HELLOWORLD
     * CPUCY
     * EKLQH
     * CHELL
     * LROWO
     * AGRBC
     * 输出
     * NO
     * 思路分析
     * 单词搜索，上下左右搜索，典型的回溯法搜索。
     * 可以参考：leetcode原题：79.单词搜索
     * 使用布尔数组变量visited，判断是否搜索过。
     * 使用布尔变量判断是否找到。
     */

}
