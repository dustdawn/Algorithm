package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小数字(100分)(字符串排序)
 * 题目描述：
 * 给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出（如果数组长度小于3，
 * 则选择数组中所有元素来组成最小数字）。
 * 输入描述：
 * 一行用半角逗号分割的字符串记录的整型数组，0 < 数组长度 <= 100，0 < 整数的取值范围 <= 10000。
 * 输出描述：
 * 由3个元素组成的最小数字，如果数组长度小于3，则选择数组中所有元素来组成最小数字。
 *
 * @author dustdawn
 * @date 2022/9/5 21:00
 */
public class MinNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        if (str.length == 1) {
            System.out.println(str[0]);
        } else if (str.length == 2) {
            int num1 = Integer.parseInt(str[0] + str[1]);
            int num2 = Integer.parseInt(str[1] + str[0]);
            System.out.println(num1 < num2 ? num1 : num2);
        } else {
            Arrays.sort(str, (e1, e2) -> Integer.parseInt(e1) - Integer.parseInt(e2));
            String[] minNum = Arrays.copyOf(str, 3);  // 复制数组的前三个数给另一个数组
            Arrays.sort(minNum, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
            String res = "";
            for (String s : minNum) {
                res += s;
            }
            System.out.println(res);
        }
        /**
         * 示例 1：
         * 输入
         * 21,30,62,5,31
         * 输出
         * 21305
         * 说明
         * 数组长度超过3，需要选3个元素组成最小数字，21305由21,30,5三个元素组成的数字，为所有组合中最小的数字
         *
         * 示例 2：
         * 输入
         * 5,21
         *
         * 输出
         * 215
         * 说明
         * 数组长度小于3，选择所有元素组成最小值，215为最小值
         *
         * 思路分析
         * 首先是选择最小的三个数，对整个数组进行排序，复制前三个数为新的数，再对三个数进行排序。这时候要求组成的字符串数字最小，则需要首字母小的数字排在字符串前面。故需要按首字母顺序进行排序。
         *
         * 整个数组排序的时候，是对Integer排序，可以在lambda表达式中转换
         * 三个数进行排序的时候，是对String组合进行排序，按组合后首字母的顺序进行排序
         */
    }
}
