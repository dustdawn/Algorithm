package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 身高体重排序(100分)(排序+哈希表)
 * 题目描述：
 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
 * 输入描述：
 * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。。
 * 输出描述：
 * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始，身高从低到高，身高相同体重从轻到重，体重相同维持原来顺序。
 *
 * @author dustdawn
 * @date 2022/9/5 16:59
 */
public class HeightWeightSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] height = in.nextLine().split(" ");
        String[] weight = in.nextLine().split(" ");
        // 不用map存储，直接二维数组，存编号，身高和体重
        int[][] ints = new int[n][3];
        for (int i = 0; i < n; i++) {
            ints[i][0] = i + 1;
            ints[i][1] = Integer.parseInt(height[i]);
            ints[i][2] = Integer.parseInt(weight[i]);
        }
        // 直接使用lambda表达式排序
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int i = 0; i < ints.length; i++) {
            if (i == ints.length - 1) {
                System.out.print(ints[i][0]);
            } else {
                System.out.print(ints[i][0] + " ");
            }
        }
        /**
         * 示例 1：
         * 输入
         * 4
         * 100 100 120 130
         * 40 30 60 50
         * 输出
         * 2 1 3 4
         * 示例 2：
         * 输入
         * 3
         * 90 110 90
         * 45 60 45
         * 输出
         * 1 3 2
         */
    }
}
