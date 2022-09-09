package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入字符串s，输出s中包含所有整数的最小和(100分)(字符串提取数字)
 * 说明
 * 1. 字符串s，只包含 a-z A-Z +- ；
 * 2. 合法的整数包括
 * 1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
 * 2）负整数 负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 输入描述:
 * 包含数字的字符串
 * 输出描述:
 * 所有整数的最小和
 *
 * @author dustdawn
 * @date 2022/9/9 21:18
 */
public class Q_MinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        List<Integer> list = new ArrayList<>();
        String temp = "";
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (flag) {
                    temp += c;    //有负号的情况下数字越大越好，直接拼接
                } else {
                    list.add(Integer.valueOf(String.valueOf(c)));   //没有负号直接加入集合
                }
            } else if (c == '-') {
                if (temp != "" && temp != "-") {    //temp中有值且不是一个“-”单字符串的情况下
                    list.add(Integer.valueOf(temp));
                }
                flag = true; //说明下一个字符串有了负号
                temp = "-";
            } else {
                /**
                 字母和“+”的情况下进入
                 * */
                if (temp != "" && temp != "-") {
                    list.add(Integer.valueOf(temp));
                }
                temp = "";  //无论之前是什么，都需要置空
                flag = false;
            }
        }
        int res = 0;
        for (int i : list) {
            res += i;
        }
        System.out.println(res);
        /**
         * 示例1
         *
         * 输入
         *
         * bb1234aa
         *
         * 输出
         *
         * 10
         *
         * 示例2
         *
         * 输入
         *
         * bb12-34aa
         *
         * 输出
         *
         * -31
         *
         * 说明
         *
         * 1+2+（-34） = 31
         */
    }
}
