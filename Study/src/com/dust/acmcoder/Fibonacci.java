package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/3 22:11
 */

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *
 * n<=39
 */
public class Fibonacci {
    //递归O(2^n)
    public static int Fibonacci1(int n) {
        /*if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci1(n-1) + Fibonacci1(n-2);*/
        return n == 0 ? 0 : (n == 1 || n == 2) ? 1 : (Fibonacci1(n-1)+Fibonacci1(n-2));
    }
    //非递归O(n)
    public static int Fibonacci2(int n) {
        int result[] = {0,1};
        if(n < 2) {
            try {
                return result[n];
            }catch(Exception e) {
                return 0;
            }

        }
        int f0 = 0;
        int f1 = 1;
        int fn = 0;
        for (int i = 0; i < n-1; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
    public static void main(String[] args) {
        System.out.println(Fibonacci1(7));
        System.out.println(Fibonacci2(7));
    }
}
