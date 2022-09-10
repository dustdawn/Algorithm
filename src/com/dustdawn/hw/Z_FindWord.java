package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找单词(200分)(多源bfs)
 * 给一个字符串和一个二维字符数组，如果该字符串存在于该数组中，则按字符串的字符顺序输出字符串每个字符所在单元格的位置下标字符串，如果找不到返回字符串"N"。
 * 1.需要按照字符串的字符组成顺序搜索，且搜索到的位置必须是相邻单元格，其中“相邻单元格”是指那些水平相邻或垂直相邻的单元格。
 * 2.同一个单元格内的字母不允许被重复使用。
 * 3.假定在数组中最多只存在一个可能的匹配。
 * 输入描述:
 * 1.第1行为一个数字（N）指示二维数组在后续输入所占的行数。
 * 2.第2行到第N+1行输入为一个二维大写字符数组，每行字符用半角,分割。
 * 3.第N+2行为待查找的字符串，由大写字符组成。
 * 4.二维数组的大小为N*N，0<N<=100。
 * 5.单词长度K，0<K<1000。
 * 输出描述:
 * 输出一个位置下标字符串，拼接格式为：第1个字符行下标+","+第1个字符列下标+","+第2个字符行下标+","+第2个字符列下标...+","+第N个字符行下标+","+第N个字符
 * 列下标
 *
 * @author dustdawn
 * @date 2022/9/10 14:48
 */
public class Z_FindWord {
    public static boolean find = false;
    public static List<int[]> list = new ArrayList<>();
    public static List<int[]> newList = new ArrayList<>();

    public static void dfs(int i, int j, char[][] board, String word, boolean[][] visited, int pos) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || find || board[i][j] != word.charAt(pos)) {
            return;
        }
        visited[i][j] = true;
        list.add(new int[]{i, j});
        if (pos == word.length() - 1) {
            find = true;
            newList = new ArrayList<>(list);
            return;
        }
        dfs(i + 1, j, board, word, visited, pos + 1);
        dfs(i - 1, j, board, word, visited, pos + 1);
        dfs(i, j + 1, board, word, visited, pos + 1);
        dfs(i, j - 1, board, word, visited, pos + 1);
        visited[i][j] = false;
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = in.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                board[i][j] = str[j].toCharArray()[0];
            }
        }
        String word = in.nextLine();
        // 回溯DFS
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(i, j, board, word, visited, 0);
                    if (find) {
                        StringBuilder sb = new StringBuilder();
                        for (int[] ints : newList) {
                            sb.append(ints[0]).append(",").append(ints[1]).append(",");
                        }
                        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
                        return;
                    }
                }
            }
        }
        System.out.println("N");
        /**
         * 示例1
         *
         * 输入
         *
         * 4
         *
         * A,C,C,F
         *
         * C,D,E,D
         *
         * B,E,S,S
         *
         * F,E,C,A
         *
         * ACCESS
         *
         * 输出
         *
         * 0,0,0,1,0,2,1,2,2,2,2,3
         *
         * 说明
         *
         * ACCESS分别对应二维数组的[0,0]  [0,1] [0,2] [1,2] [2,2] [2,3]下标位置
         */
    }
}
