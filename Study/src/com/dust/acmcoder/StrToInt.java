package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/15 13:00
 */

/**
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 *
 * 输入一个字符串,包括数字字母符号,可以为空
 *
 * 输出描述:
 *
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 *+2147483647
 *  1a33
 *
 *  2147483647
 *  0
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str == null) {
            throw new NumberFormatException("null");
        }
        int i = 0, len = str.length();
        int result = 0;
        boolean negative = false;
        if (len > 0) {
            char firstChar = str.charAt(0);
            if (firstChar < '0') {//第一位为符号位
                if (firstChar == '-') {
                    negative = true;
                }else if (firstChar != '+') {
                    return 0;
                }
                if (len == 1) {
                    return 0;
                }
                ++i;//符号位判断完毕
            }

            while (i < len) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    int digit = str.charAt(i++) - '0';
                    result = result * 10 + digit;
                }else {
                    return 0;
                }
            }
            return negative ? -result : result;


        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("+2147483647"));
    }
}
