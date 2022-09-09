package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 流水线(100分)(排序+Stream)
 * 一个工厂有m条流水线，来并行完成n个独立的作业，该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 * 现给定流水线个数m，需要完成的作业数n, 每个作业的处理时间分别为t1,t2…tn。请你编程计算处理完所有作业的耗时为多少？
 * 当n>m时，首先处理时间短的m个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 * 输入描述:
 * 第一行为2个整数（采用空格分隔），分别表示流水线个数m和作业数n；
 * 第二行输入n个整数（采用空格分隔），表示每个作业的处理时长t1,t2…tn。
 * 0< m,n<100，0<t1,t2…tn<100。
 * 注：保证输入都是合法的。
 * 输出描述:
 * 输出处理完所有作业的总时长
 *
 * @author dustdawn
 * @date 2022/9/9 20:30
 */
public class L_FlowLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   //流水线个数
        int n = sc.nextInt();   //作业数
        int[] ints = new int[n];    //作业数组
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }
        Arrays.sort(ints);  //对作业进行排序（升序）
        int res = 0;
        int[] count = new int[m];   //流水线数组
        int index = 0;
        for (int i = 0; i < n; i++) {
            res = Arrays.stream(count).min().getAsInt();    //求流水线中最短时间的线
            for (int j = 0; j < m; j++) {
                if (res == count[j]) {    //求出流水线最短时间线的下标
                    index = j;
                    break;
                }
            }
            count[index] += ints[i];
        }

        System.out.println(Arrays.stream(count).max().getAsInt());
        /**
         * 示例1
         *
         * 输入
         *
         * 3 5
         *
         * 8 4 3 2 10
         *
         * 输出
         *
         * 13
         *
         * 说明
         *
         * 1、先安排时间为2、3、4的3个作业。
         *
         * 2、第一条流水线先完成作业，然后调度剩余时间最短的作业8。
         *
         * 3、第二条流水线完成作业，然后调度剩余时间最短的作业10。
         *
         * 4、总工耗时就是第二条流水线完成作业的时间13（3+10）。
         */
    }
}
