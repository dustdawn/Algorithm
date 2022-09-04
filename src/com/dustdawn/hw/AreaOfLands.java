package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 最大岛屿体积
 * 题目描述
 * 给你一个由 大于0的数（陆地）和 0（水）组成的的二维网格，请你计算网格中最大岛屿的体积。陆地的数表示所在岛屿的体积。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 输入描述
 * 第一行是二维网格的宽和高。
 * 后面几行是二维网格。
 * 输出描述
 * 输出岛屿的最大体积。
 *
 * @author dustdawn
 * @date 2022/9/4 14:09
 */
public class AreaOfLands {
    /**
     * 样例
     * 输入
     * 5 5
     * 0 1 1 0 0
     * 0 1 1 0 0
     * 0 0 0 0 0
     * 0 0 1 2 3
     * 0 0 1 3 9
     * 输出
     * 19
     * 思路分析
     * 这道题完完全全就是leetcode上的200.岛屿的数量，那道题是统计岛屿的个数，这个题是统计最大岛屿的体积。
     * 在dfs里面累加各个小岛屿的体积，然后在外面判断是否最大。
     */
    public static int area = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        int[][] nums = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] > 0) {
                    area = 0;
                    dfs(nums, i, j);
                    res = Math.max(res, area);
                }
            }
        }
        System.out.println(res);
    }

    public static void dfs(int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || nums[i][j] == 0) {
            return;
        }
        area += nums[i][j];
        nums[i][j] = 0;
        dfs(nums, i + 1, j);
        dfs(nums, i, j + 1);
        dfs(nums, i - 1, j);
        dfs(nums, i, j - 1);
    }
}
