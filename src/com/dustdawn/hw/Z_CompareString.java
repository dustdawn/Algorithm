package com.dustdawn.hw;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 字符串比较(100分)(栈+滑动窗口)
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
        char[] s1 = sc.nextLine().toCharArray();
        char[] s2 = sc.nextLine().toCharArray();
        int v = sc.nextInt();
        int max = 0;
        int length = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int sum = Math.abs(s1[0] -s2[0]);
        queue.offer(sum);
        for (int i = 1; i < s1.length; i++) {
            int temp = Math.abs(s1[i] -s2[i]);
            queue.offer(temp);
            sum += temp;
            if (sum <= v) {
                length = queue.size();
            } else {
                sum -= queue.poll();
            }
            max = Math.max(length, max);
        }
        System.out.println(max);
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
