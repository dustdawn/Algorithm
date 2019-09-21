package com.dust.acmcoder;

import java.util.ArrayList;

/**
 * @author dustdawn
 * @date 2019/9/21 11:38
 */

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class printMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (true) {
            //左到右
            for (int j = left; j <= right; j++) {
                list.add(matrix[up][j]);
            }
            up++;
            if (up > down) {
                break;
            }
            //上到下
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            //右到左
            for (int j = right; j >= left; j--) {
                list.add(matrix[down][j]);
            }
            down--;
            if (down < up) {
                break;
            }
            //下到上
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        printMatrix o = new printMatrix();
        System.out.println(o.printMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}).toString());
    }
}
