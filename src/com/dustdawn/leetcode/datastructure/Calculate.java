package com.dustdawn.leetcode.datastructure;

import java.util.Stack;

/**
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 *
 * @author dustdawn
 * @date 2022/5/18 20:44
 */
public class Calculate {
    static Stack<Integer> stack = new Stack<>();
    /**
     * 全局坐标i
     */
    static int i = 0;

    public static int calculate(String s) {
        /*
        sign：当前运算符
        num：当前数字（一个括号结果视为一个数字）
        count：当前层的元素个数（一个括号整体为一个计数）
         */
        int num = 0;
        char sign = '+';
        int count = 0;
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果为数字，连续读取出来（括号防止整型溢出）
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0');
            }
            /*
            括号采用递归解法，calculate(3*(4-5/2)-6) = 3*calculate(4-5/2)-6
            遇到(开始递归，遇到)结束递归
             */
            if (ch == '(') {
                i++;
                num = calculate(s);
            }
            // 如果不为数字或者空格，说明遇到了符号，或同时走到尽头时
            // 此时来处理栈顶元素与num根据sign的运算结果，再将结果入栈
            // 上一个符号为乘法和除法符号会将上一个入栈的数字结果（符号+数字）与当前的num做对应运算
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        count++;
                        stack.push(num);
                        break;
                    case '-':
                        count++;
                        stack.push(-num);
                        break;
                    case '*':
                        count++;
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        count++;
                        stack.push(stack.pop() / num);
                        break;
                }
                if (ch == ')') {
                    return stackTotal(count);
                }
                // 更新符号并还原num
                sign = ch;
                num = 0;
            }
        }
        return stackTotal(count);
    }

    /**
     * 计算站内元素和
     * count 为计算元素的个数
     *
     * @param count
     * @return
     */
    public static int stackTotal(int count) {
        int total = 0;
        int i = 0;
        while (!stack.isEmpty() && i < count) {
            i++;
            total += stack.pop();
        }
        return total;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：s = "1 + 1"
         * 输出：2
         * 示例 2：
         *
         * 输入：s = " 2-1 + 2 "
         * 输出：3
         * 示例 3：
         *
         * 输入：s = "(1+(4+5+2)-3)+(6+8)"
         * 输出：23
         */
        System.out.println(calculate(" 2-1 + 2 "));
    }
}
