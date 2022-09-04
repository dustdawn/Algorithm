package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 非严格递增连续数字序列(循环穷举)
 * 题目描述：
 * 输入一个字符串仅包含大小写字母和数字，求字符串中包含的最长的非严格递增连续数字序列的长度
 * （比如12234属于非严格递增连续数字序列）。
 *
 * @author dustdawn
 * @date 2022/9/3 16:56
 */
public class IncreaseNumSubsequences {
    /**
     * 输入描述:
     * 输入一个字符串仅包含大小写字母和数字，输入的字符串最大不超过255个字符。
     * 输出描述：
     * 最长的非严格递增连续数字序列的长度
     * 示例 1：
     * 输入
     * abc2234019A334bc
     * 输出
     * 4
     * 说明：
     * 2234为最长的非严格递增连续数字序列，所以长度为4
     * 测试用例
     * aaaaaa44ko543j123j7345677781    -->  34567778 8
     * aaaaa34567778a44ko543j123j71    -->  34567778 8
     * 345678a44ko543j123j7134567778aa -->  134567778 9
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chs = str.toCharArray();
        int maxLen = 0;
        int len = 0;
        int pre = 0;
        for (char ch : chs) {
            if (Character.isDigit(ch)) {
                if (pre <= ch) {
                    len++;
                    maxLen = Math.max(maxLen, len);
                } else {
                    len = 1;
                }
                pre = ch;
            } else {
                len = 0;
                pre = 0;
            }
        }
        System.out.println(maxLen);
    }
}
