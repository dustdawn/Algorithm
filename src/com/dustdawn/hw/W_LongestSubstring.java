package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 无重复字符的元素长度乘积的最大值(100分)(排序+穷举)
 * 题目描述：
 * 给定一个元素类型为小写字符串的数组，请计算两个没有相同字符的元素长度乘积的最大值。
 * 如果没有符合条件的两个元素返回0。
 * 输入描述：
 * 输入为一个半角逗号分割的小写字符串数组
 * 2<= 数组长度 <=100
 * 0< 字符串长度 <=50
 * 输出描述
 * 两个没有相同字符的元素长度乘积的最大值
 *
 * @author dustdawn
 * @date 2022/9/3 16:44
 */
public class W_LongestSubstring {
    public static boolean isSame(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (isSame(str[i], str[j])) {
                    continue;
                }
                int len = str[i].length() * str[j].length();
                max = Math.max(max, len);
            }
        }
        System.out.println(max);
        /**
         * 示例 1：
         * 输入
         * iwdvpbn,hk,iuop,iikd,kadgpf
         * 输出
         * 14
         * 说明：
         * 数组中有5个元素。
         * iwdvpbn与hk无相同的字符，满足条件，iwdvpbn的长度为7，hk的长度为2，乘积为14（7*2）。
         * iwdvpbn与iuop、iikd、kadgpf均有相同的字符，不满足条件。
         * iuop与iikd、kadgpf均有相同的字符，不满足条件。
         */
    }
}
