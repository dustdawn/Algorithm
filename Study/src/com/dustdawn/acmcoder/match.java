package com.dustdawn.acmcoder;

import java.util.Arrays;

/**
 * @author dustdawn
 * @date 2019/9/15 15:37
 */

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的一个字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 说明:
 *
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false

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
            //*表示匹配前一个字符0次多次，以下情况满足任意一个则符合
            //1.匹配0次，跳过前两个字符， 模式串下移，新的模式串与匹配串进行匹配
            //2.匹配多次，如果第一个字符匹配(模式串第一个字符为.或两串字符相同)
            //   1)两字符组合成.*  表示匹配任意字符任意次, 匹配串直接右移到最后一个元素，
            //      进入else，此时进行下一次递归的str长度为空，如果模式串只含有.*，则两原串匹配，否则不匹配
            //   2)两字符组合成 字符*  表示匹配字符多次，则比较匹配串的下一字符是否与 模式串的 字符串* 相同
            return ( match(str, Arrays.copyOfRange(pattern, 2, pattern.length)) )
                    ||
                    (firstMatch && match(Arrays.copyOfRange(str, 1, str.length), pattern));
        }else {

            //如匹配字符串和模式字符串都走到最后一个元素，match参数均为空数组,返回true && true,出口
            return firstMatch && match(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 1, pattern.length));

        }

    }

    public static void main(String[] args) {

        System.out.println(new match().match(new char[]{'a','a','b'}, new char[]{'.','*','a','*','b'}));
        System.out.println(new match().match(new char[]{}, new char[]{'.','*','a'}));

        //System.out.println(Arrays.toString(Arrays.copyOfRange(new int[]{1,2,3}, 3, 3)));
    }
}
