package com.dustdawn.hw;

import java.util.Scanner;
import java.util.Stack;

/**
 * 报文解压缩(200分)(栈括号处理)
 * 题目描述
 * 为了提升数据传输的效率，会对传输的报文进行压缩处理。
 * 输入一个压缩后的报文，请返回它解压后的原始报文。
 * 压缩规则：n[str]，表示方括号内部的 str 正好重复 n 次。
 * 注意 n 为正整数（0 < n <= 100），str只包含小写英文字母，不考虑异常情况。
 * 输入描述
 * 输入压缩后的报文：
 * 1）不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的；
 * 2）原始报文不包含数字，所有的数字只表示重复的次数 n ，例如不会出现像 5b 或 3[8] 的输入；
 * 输出描述
 * 解压后的原始报文
 * 注：
 * 1）原始报文长度不会超过1000，不考虑异常的情况
 *
 * @author dustdawn
 * @date 2022/9/3 18:14
 */
public class B_MessageCompress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ']') {
                String temp = "";
                // 解压缩
                while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (Character.isLetter(pop)) {
                        temp = pop + temp;
                    } else if (Character.isDigit(pop)) {
                        int n = 0;
                        // 确定数字位数
                        if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                            n = (pop - '0') + (stack.pop() - '0') * 10;
                            if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                                n += (stack.pop() - '0') * 100;
                            }
                        } else {
                            n = pop - '0';
                        }
                        String t = temp;
                        for (int j = 0; j < n - 1; j++) {
                            temp += t;
                        }
                    }
                }
                sb.append(temp);
            }
            stack.push(ch);
        }
        System.out.println(sb.toString());
        /**
         * 示例
         * 输入
         * 3[m2[c]]
         * 输出
         * mccmccmcc
         * 说明
         * m2[c] 解压缩后为 mcc，重复三次为 mccmccmcc
         * 输入
         * 10[k]2[mn3[j2[op]]]
         * 输出
         * kkkkkkkkkkmnjopopjopopjopopmnjopopjopopjopop
         * 思路分析
         * 这道题是字符串处理的问题，同时字符串中嵌套括号，根据嵌套的括号进行报文解压缩，所以我们很容易想到用栈去解决问题。
         * 首先把右括号之前的字符入栈。
         * 遇到右括号时，开始进行解压缩，当栈不空的情况下开始出栈
         * 出栈字符为字母时，暂存
         * 出栈字符为数字时，判断如果前一个字符存在，是否仍为数字（处理两位数字，这里没有对数字100进行判断，如果需要再加一个判断即可）
         * 循环num-1次累加暂存的字符串，因为本身有一次
         * 注意：题目要求的压缩规则：n[str]，str只包含小写英文字母。所以左括号左边一定是数字。
         * 3[[m2[c]]2[a]]
         * 则不符合压缩规则。
         */
    }
}
