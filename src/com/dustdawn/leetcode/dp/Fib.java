package com.dustdawn.leetcode.dp;

/**
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 * @author dustdawn
 * @date 2022/2/26 15:07
 */
public class Fib {
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int temp = 1;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            temp = b;
            b += a;
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
