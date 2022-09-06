package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 寻找相同子串(100分)(字符串)
 * 给你两个字符串 t 和 p ，要求从 t 中找到一个和 p 相同的连续子串，并输出该字串第一个字符的下标。
 * 输入描述:
 * 输入文件包括两行，分别表示字符串 t 和 p ，保证 t 的长度不小于 p ，且 t 的长度不超过1000000，p 的长度不超过10000。
 * 输出描述:
 * 如果能从 t 中找到一个和 p 相等的连续子串，则输出该子串第一个字符在t中的下标（下标从左到右依次为1,2,3,…）；
 * 如果不能则输出”No”；如果含有多个这样的子串，则输出第一个字符下标最小的。
 *
 * @author dustdawn
 * @date 2022/9/6 15:46
 */
public class X_FindSameSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        if (t.length() > 1000000) {
            System.out.println("No");
        }
        String p = sc.nextLine();
        if (p.length() > t.length() && p.length() > 10000) {
            System.out.println("No");
        }
        if (t.contains(p)) {
            System.out.println(t.indexOf(p) + 1);
        } else {
            System.out.println("No");
        }

        /**
         * 示例1
         *
         * 输入
         *
         * AVERDXIVYERDIAN
         *
         * RDXI
         *
         * 输出
         *
         * 4
         */
    }
}
