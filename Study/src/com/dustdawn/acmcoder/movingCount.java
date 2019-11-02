package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/14 22:37
 */

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class movingCount {
    public int movingCount(int threshold, int rows, int cols) {
        //int[][] coordinate = new int[rows][cols];
        /*for (int i = 0; i < coordinate.length; i++) {
            for (int j = 0; j < coordinate[i].length; j++) {
                if (digitSum(i) + digitSum(j) <= threshold) {
                    ++count;
                }
            }
        }*/
        boolean[][] isVisited = new boolean[rows][cols];
        return recall(threshold, 0,  0, isVisited);

    }
    public int recall(int threshold, int rows, int cols, boolean[][] isVisited) {
        int count = 0;


        //从边界回溯统计
        if (rows >= 0 && rows < isVisited.length   &&   cols >=0 && cols < isVisited[0].length   &&   !isVisited[rows][cols]) {
            if (digitSum(rows) + digitSum(cols) <= threshold) {
                isVisited[rows][cols] =true;
                count += 1
                        + recall(threshold, rows, cols+1, isVisited)
                        + recall(threshold, rows, cols-1, isVisited)
                        + recall(threshold, rows+1, cols, isVisited)
                        + recall(threshold, rows-1, cols, isVisited);
            }
        }
        return count;
    }

    //暴力求解位数和
    public int digitSum(int num) {
        int count = 0;
        while (num != 0) {
            count += num % 10;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new movingCount().movingCount(10, 1, 100));

    }
}
