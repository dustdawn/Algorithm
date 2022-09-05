package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 整数最小和(100分)(字符串提取数字符号)
 * 题目描述：
 * 输入字符串s，输出s中包含所有整数的最小和
 * 说明：
 * 字符串s，只包含 a-z A-Z ± ；
 * 合法的整数包括
 * 1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
 * 2）负整数 负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 输入描述：
 * 包含数字的字符串
 * 输出描述：
 * 所有整数的最小和
 *
 * @author dustdawn
 * @date 2022/9/5 16:05
 */
public class IntegerMinSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] ch = str.toCharArray();
        int sum = 0;
        boolean flag = false; // 负数
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (c >= '0' && c <= '9') {  // 如果是数字
                if (flag) {  // 如果是负号后面的数字，加到sb中
                    sb.append(c);
                } else {  // 正数直接求和
                    sum += Integer.parseInt(c + "");
                }
            } else if ('-' == c) {  // 如果是'-'
                if (flag) {
                    if (!sb.toString().isEmpty()) {  // 遇到负号后，将负号后面的连续数字组成字符串
                        sum -= Integer.parseInt(sb.toString());  // 如果sb不空
                        sb = new StringBuilder();
                    }
                }
                flag = true;
            } else {  // 其它字符
                flag = false;  // 用来判断负号后的字符串结束
                if (!sb.toString().isEmpty()) {  // 队列不空，说明负号字符串到此为止，将去整体
                    sum -= Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if (flag) {
            if (!sb.toString().isEmpty()) {
                sum -= Integer.parseInt(sb.toString());
            }
        }
        System.out.println(sum);
        /**
         * 示例 1：
         * 输入
         * bb1234aa
         * 输出
         * 10
         * 说明
         * 1+2+3+4=10
         * 示例 2：
         * 输入
         * bb12-34aa
         * 输出
         * -31
         * 说明
         * 1+2+（-34） = 31
         * 思路分析
         * 这道题主要是负号的判断，遇到负号的时候，负号后面跟的数字字符串作为一个整体，才能最小。没有遇到负号的时候，单个字符相加，和最小。所以在flag=true的情况下，把所有数字加入字符串，之后无论遇到其它字符或者再遇到负号，都用sum减去这个整体字符串对应的整数。
         */
    }
}
