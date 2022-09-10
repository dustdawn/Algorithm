package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 事件推送(100分)(数组比较排序)
 * 同一个数轴X上有两个点的集合A={A1, A2, …, Am}和B={B1, B2, …, Bn}，Ai和Bj均为正整数，A、B已经按照从小到大排好序，A、B均不为空，给定一个距离R(正整数)，
 * 列出同时满足如下条件的所有（Ai, Bj）数对：
 * 1）Ai <= Bj
 * 2）Ai, Bj之间的距离小于等于R
 * 3）在满足1）2）的情况下，每个Ai只需输出距离最近的Bj
 * 4）输出结果按Ai从小到大的顺序排序
 * 输入描述:
 * 第一行三个正整数m，n，R
 * 第二行m个正整数，表示集合A
 * 第三行n个正整数，表示集合B
 * 输入限制：
 * 1<=R<=100000，1<=n,m<=100000，1<=Ai,Bj<=1000000000
 * 输出描述:
 * 每组数对输出一行Ai和Bj，以空格隔开
 *
 * @author dustdawn
 * @date 2022/9/9 20:23
 */
public class S_EventPush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int R = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int index = 0;  //B数组下标
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {    //遍历A数组
            int[] ints = new int[2];    //用来放置A、B数字
            while (index < b.length) {  //
                if (a[i] <= b[index] && b[index] - a[i] <= R) {
                    ints[0] = a[i];
                    ints[1] = b[index];
                    list.add(ints);
                    break;
                }
                index++;    //因为两数组都是从大到小排列，index可以公用
            }
        }

        list.forEach(e -> {
            System.out.println(e[0] + " " + e[1]);
        });

        /**
         * 示例1
         *
         * 输入
         *
         * 4 5 5
         *
         * 1 5 5 10
         *
         * 1 3 8 8 20
         *
         * 输出
         *
         * 1 1
         *
         * 5 8
         *
         * 5 8
         */
    }
}
