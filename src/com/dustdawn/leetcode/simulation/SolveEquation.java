package com.dustdawn.leetcode.simulation;

/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * 如果方程没有解或存在的解不为整数，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 * 提示:
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * 方程由绝对值在 [0, 100]  范围内且无任何前导零的整数和变量 'x' 组成。
 *
 * @author dustdawn
 * @date 2022/9/11 21:46
 */
public class SolveEquation {
    public static String solveEquation(String equation) {
        // x项系数
        int factor = 0;
        // 常量
        int val = 0;
        int sign1 = 1;
        int index = 0;
        int n = equation.length();
        while (index < n) {
            if (equation.charAt(index) == '=') {
                sign1 = -1;
                index++;
                continue;
            }
            int sign2 = sign1;
            int number = 0;
            // 是否有数字
            boolean valid = false;
            if (equation.charAt(index) == '-') {
                sign2 = -sign2;
                index++;
            } else if (equation.charAt(index) == '+') {
                index++;
            }
            while (index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + (equation.charAt(index) - '0');
                valid = true;
                index++;
            }
            if (index < n && equation.charAt(index) == 'x') {
                // 为变量
                if (valid) {
                    factor += number * sign2;
                } else {
                    factor += sign2;
                }
                index++;
            } else {
                // 为数字
                val += sign2 * number;
            }
        }
        if (factor == 0) {
            if (val == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + (-val / factor);
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         * 输入: equation = "x+5-3+x=6+x-2"
         * 输出: "x=2"
         * 示例 2:
         * 输入: equation = "x=x"
         * 输出: "Infinite solutions"
         * 示例 3:
         * 输入: equation = "2x=x"
         * 输出: "x=0"
         */
    }
}
