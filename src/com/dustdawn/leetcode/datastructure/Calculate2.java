package com.dustdawn.leetcode.datastructure;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * @author dustdawn
 * @date 2022/5/19 10:11
 */
public class Calculate2 {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        // 取出的数字
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果为数字，连续读取出来（括号防止整型溢出）
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0');
            }
            // 如果不为数字或者空格，说明遇到了符号，或同时走到尽头时
            // 此时来处理栈顶元素与num根据sign的运算结果，再将结果入栈
            // 上一个符号为乘法和除法符号会将上一个入栈的数字结果（符号+数字）与当前的num做对应运算
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                // 更新符号并还原num
                sign = ch;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：s = "3+2*2"
         * 输出：7
         * 示例 2：
         *
         * 输入：s = " 3/2 "
         * 输出：1
         * 示例 3：
         *
         * 输入：s = " 3+5 / 2 "
         * 输出：5
         */
    }
}
