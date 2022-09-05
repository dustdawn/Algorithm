package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 字符串变换最小字符串(100分)(选择排序)
 * 题目描述：
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
 * 变换规则：交换字符串中任意两个不同位置的字符。
 * 输入描述：
 * 一串小写字母组成的字符串s。
 * 输出描述：
 * 按照要求进行变换得到的最小字符串。
 * 备注：
 * s是都是小写字符组成
 * 1<=s.length<=1000
 *
 * @author dustdawn
 * @date 2022/9/5 20:25
 */
public class ChangeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cArr = str.toCharArray();
        char tmp = cArr[0];
        int tmpIndex = 0;
        for (int left = 0; left < cArr.length; left++) {
            tmp = cArr[left];
            tmpIndex = left;
            for (int i = left; i < cArr.length; i++) {
                if (cArr[i] < tmp) {
                    tmp = cArr[i];
                    tmpIndex = i;
                }
            }
            if (tmpIndex != left) {
                cArr[tmpIndex] = cArr[left];
                cArr[left] = tmp;
                break;
            }
        }
        str = String.valueOf(cArr);
        System.out.println(str);
        /**
         * 示例
         * 输入：abcdef
         *
         * 输出：abcdef
         *
         * 说明：abcdef已经是最小字符串，不需要交换
         *
         *
         * 输入：bcdefa
         *
         * 输出：acdefb
         *
         * 说明：a和b进行位置交换，可以得到最小字符串
         */
    }
}
