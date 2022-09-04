package com.dustdawn.hw;

import java.util.Scanner;
import java.util.Stack;

/**
 * 最大嵌套括号深度
 * 题目描述：
 * 现有一字符串仅由 ‘(’， ‘)’， ‘{’， ‘}’， ‘[’， ']'六种括号组成。 若字符串满足以下条件之一，则为无效字符串：
 * ①任一类型的左右括号数量不相等；
 * ②存在未按正确顺序（先左后右）闭合的括号。
 * 输出括号的最大嵌套深度，若字符串无效则输出 0。 0≤字符串长度≤100000
 * 输入描述:
 * 一个只包括 ‘(’， ‘)’， ‘{’， ‘}’， ‘[’， ']'的字符串
 * 输出描述：
 * 一个整数，最大的括号深度
 *
 * @author dustdawn
 * @date 2022/9/3 20:44
 */
public class BracketDepth {
    /**
     * 示例 1：
     * 输入
     * []
     * 输出
     * 1
     * 说明
     * 有效字符串，最大嵌套深度为1
     * 示例 2：
     * 输入
     * ([]{()})
     * 输出
     * 3
     * 说明
     * 有效字符串，最大嵌套深度为3
     * 示例 3：
     * 输入
     * (]
     * 输出
     * 0
     * 说明
     * 无效字符串，有两种类型的左右括号数量不相等
     * 示例 4：
     * 输入
     * ([)]
     * 输出
     * 0
     * 说明
     * 无效字符串，存在未按正确顺序闭合的括号
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        char[] chs = str.toCharArray();
        int i = 0;
        for (; i < chs.length; i++) {
            if (chs[i] == '(' || chs[i] == '[' || chs[i] == '{') {
                stack.push(chs[i]);
                depth = Math.max(stack.size(), depth);
            } else {
                if (stack.isEmpty()) {
                    break;
                } else if (getLeft(chs[i]) == stack.pop()) {
                    continue;
                }
                break;
            }
        }
        if (i == chs.length && stack.isEmpty()) {
            System.out.println(depth);
        } else {
            System.out.println(0);
        }
    }

    public static char getLeft(char r) {
        if (r == ')') {
            return '(';
        } else if (r == ']') {
            return '[';
        }
        return '{';
    }
}
