package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/4 9:49
 */

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 */
public class Power {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        int e = exponent > 0 ? exponent : -exponent;
        double result = 1.0d;
        while (e > 0) {
            result *= base;
            --e;
        }
        return exponent > 0 ? result : 1 / result;
    }

}
