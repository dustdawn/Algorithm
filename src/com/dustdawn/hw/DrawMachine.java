package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 绘图机器(100分)(数组)
 * 题目描述：
 * 绘图机器的绘图笔初始位置在原点(0,0) 机器启动后按照以下规则来进行绘制直线
 * 尝试沿着横线坐标正向绘制直线 直到给定的终点E
 * 期间可以通过指令在纵坐标轴方向进行偏移 offsetY为正数表示正向偏移,为负数表示负向偏移
 * 给定的横坐标终点值E 以及若干条绘制指令 请计算绘制的直线和横坐标轴以及x=E的直线组成的图形面积
 * 输入描述:
 * 首行为两个整数N 和 E 表示有N条指令, 机器运行的横坐标终点值E
 * 接下来N行 每行两个整数表示一条绘制指令x offsetY
 * 用例保证横坐标x以递增排序的方式出现 且不会出现相同横坐标x
 * 取值范围: 0<N<=10000
 * 0<=x<=E<=20000
 * -10000<=offsetY<=10000
 * 输出描述：
 * 一个整数表示计算得到的面积 用例保证结果范围在0到4294967295之内
 *
 * @author dustdawn
 * @date 2022/9/5 15:41
 */
public class DrawMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);
        int[] x = new int[n];
        int[] offsetY = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            offsetY[i] = in.nextInt();
        }
        int area = 0;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            area += (x[i] - a) * Math.abs(b);
            a = x[i];
            b += offsetY[i];
        }
        area += (end - a) * Math.abs(b);
        System.out.println(area);
        /**
         * 示例 1：
         *
         * 输入
         * 4 10
         * 1 1
         * 2 1
         * 3 1
         * 4 -2
         * 输出
         * 12
         * 说明
         * 通过操作机器最后绘制了如下图形（蓝色为绘制笔绘制的直线）
         *
         * 计算图中阴影部分面积，其值为
         *
         * 1*1+2*1+3*1+1*6=12
         * 示例 2：
         *
         * 输入
         * 2 4
         * 0 1
         * 2 -2
         * 输出
         * 4
         * 思路分析：
         */
    }
}
