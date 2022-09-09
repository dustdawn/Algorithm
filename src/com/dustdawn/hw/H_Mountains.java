package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 猴子爬山(100分)(斐波那契)
 * 一天一只顽猴想去从山脚爬到山顶，途中经过一个有个N个台阶的阶梯，但是这猴子有一个习惯： 每一次只能跳1步或跳3步，试问猴子通过这个阶梯有多少种不同的跳跃方式？
 *  输入描述:
 *  输入只有一个整数N（0<N<=50）此阶梯有多少个阶梯
 *  输出描述:
 *  输出有多少种跳跃方式（解决方案数）
 *
 * @author dustdawn
 * @date 2022/9/9 21:35
 */
public class H_Mountains {
    public static int recursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        return recursion(n - 1) + recursion(n - 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(recursion(n));
        int a = 1;
        int b = 1;
        int c = 2;
        for (int i = 3; i < n; i++) {
            int temp = a + c;
            a = b;
            b = c;
            c = temp;
        }
        System.out.println(c);
        /**
         * 示例1
         *
         * 输入
         *
         * 50
         *
         * 输出
         *
         * 122106097
         *
         * 示例2
         *
         * 输入
         *
         * 3
         *
         * 输出
         *
         * 2
         */
    }
}
