package com.dust.acmcoder;

import java.util.Arrays;

/**
 * @author dustdawn
 * @date 2019/9/15 15:37
 */

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的一个字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class match {
    public boolean match(char[] str, char[] pattern) {

        if(pattern.length == 0) {
            return str.length == 0 ? true : false;//模式串为空，则如果匹配串为空符合
        }
        //模式串不为空的情况下
        boolean firstMatch = false;//每次匹配一个字符,如匹配串为空则返回false
        if (str.length != 0) {//非空匹配串，字符相同或模式串的字符如果为 . 则符合
            if (pattern[0] == str[0] || pattern[0] == '.') {//
                firstMatch = true;//第一个字符是否匹配
            }
        }

        //模式串中有*号，则出现在当前字符的后一位pattern[1]
        if (pattern.length >= 2 && pattern[1] == '*') {//递归比较下一字符
            //*表示匹配前一个字符多次，以下情况满足任意一个则符合
            //1.
            // *匹配0次，跳过前两个字符， 模式串下移，新的模式串与匹配串进行匹配
            //2.如果第一个字符匹配，则删去*号，直接匹配下一个模式串
            return ( match(str, Arrays.copyOfRange(pattern, 2, pattern.length)) )
                    ||
                    (firstMatch && match(Arrays.copyOfRange(str, 1, str.length), pattern));
        }else {

            //如匹配字符串和模式字符串都走到最后一个元素，match参数均为空字符串,返回true && true,出口
            return firstMatch && match(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 1, pattern.length));

        }

    }

    public static void main(String[] args) {

        System.out.println(new match().match(new char[]{'a','a','b'}, new char[]{'.','*','a','*','b'}));
        System.out.println(new match().match(new char[]{}, new char[]{'.','*'}));

        //System.out.println(Arrays.toString(Arrays.copyOfRange(new int[]{1,2,3}, 3, 3)));
    }
}
