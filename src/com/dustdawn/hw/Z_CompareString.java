package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 字符串比较(200分)(滑动窗口)
 * 题目描述
 * 给定字符串A、B和正整数V，A的长度与B的长度相等， 请计算A中满足如下条件的最大连续子串的长度：
 * 1、该连续子串在A和B中的位置和长度均相同。
 * 2、该连续子串|A[i] – B[i]|之和小于等于V。其中|A[i] – B[i]|表示两个字母ASCII码之差的绝对值。
 * 输入描述：
 * 输入为三行：
 * 第一行为字符串A，仅包含小写字符，1 <= A.length <=1000。
 * 第二行为字符串B，仅包含小写字符，1 <= B.length <=1000。
 * 第三行为正整数V，0<= V <= 10000。
 * 输出描述：
 * 字符串最大连续子串的长度，要求该子串|A[i] – B[i]|之和小于等于V。
 *
 * @author dustdawn
 * @date 2022/9/6 12:51
 */
public class Z_CompareString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int V = sc.nextInt();
        char[] Aarr = A.toCharArray();
        char[] Barr = B.toCharArray();
        int sum = 0;
        int start = -1;
        int end = -1;
        int max = 0;
        int diff;
        int i = 0;
        while (i < Aarr.length) {
            diff = Math.abs(Aarr[i] - Barr[i]);
            if (diff > V) {
                i++;
                continue;
            }
            int curStart = i;
            sum = diff;
            while (sum <= V && i < Aarr.length) {
                i++;
                if (i >= Aarr.length) {
                    break;
                }
                diff = Math.abs(Aarr[i] - Barr[i]);
                if (diff + sum > V) {
                    break;
                } else {
                    sum += diff;
                }
            }
            if (max < i - curStart) {
                max = sum;
                start = curStart;
                end = i - 1;
            }
            i = curStart + 1;
        }
        System.out.println(end - start + 1);
        /**
         * 示例 1 输入输出示例仅供调试，后台判题数据一般不包含示例
         * 输入
         * xxcdefg
         * cdefghi
         * 5
         * 输出
         * 2
         * 字符串A为xxcdefg，字符串B为cdefghi，V=5。
         * 它的最大连续子串可以是cd->ef,de->fg,ef->gh,fg->hi，所以最大连续子串是2。
         */
    }
}
