package com.dustdawn.leetcode.dp;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * @author dustdawn
 * @date 2022/2/26 15:22
 */
public class Tribonacci {
    public static int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}
