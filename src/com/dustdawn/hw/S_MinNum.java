package com.dustdawn.hw;

import java.util.*;

/**
 * 数组组成的最小数字(100分)(字符串排序规则)
 * 给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出（如果数组长度小于3，则选择数组中所有元素来组成最小数字）。
 * 输入描述:
 * 一行用半角逗号分割的字符串记录的整型数组，0 < 数组长度 <= 100，0 < 整数的取值范围 <= 10000。
 * 输出描述:
 * 由3个元素组成的最小数字，如果数组长度小于3，则选择数组中所有元素来组成最小数字。
 *
 * @author dustdawn
 * @date 2022/9/9 21:51
 */
public class S_MinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        int slen = strings.length;
        String res = "";

        if (slen == 1) {    //考虑到只有一个数的情况
            res = strings[0];
        } else {
            List<String> list = new ArrayList<>();
            int[] ints = new int[slen];
            for (int i = 0; i < slen; i++) {
                ints[i] = Integer.valueOf(strings[i]);
            }
            Arrays.sort(ints);  //对数组进行排序
            int numsLen;
            if (slen == 2) {    //区别只有两个数的情况
                numsLen = 2;
            } else {
                numsLen = 3;
            }
            for (int i = 0; i < numsLen; i++) {
                list.add(String.valueOf(ints[i]));
            }
            Collections.sort(list); //list排序可以按照第一位数大小排序（升序）
            for (int i = 0; i < numsLen; i++) {
                res += list.get(i);
            }
        }
        System.out.println(Integer.valueOf(res));

        /**
         * 示例1
         *
         * 输入
         *
         * 21,30,62,5,31
         *
         * 输出
         *
         * 21305
         *
         * 说明
         *
         * 数组长度超过3，需要选3个元素组成最小数字，21305由21,30,5三个元素组成的数字，为所有组合中最小的数字
         *
         * 示例2
         *
         * 输入
         *
         * 5,21
         *
         * 输出
         *
         * 215
         *
         * 说明
         *
         * 数组长度小于3， 选择所有元素来主城最小值，215为最小值。
         *
         * 解题思路：
         * 1、因为是要获取最小值，所以组成数字的元素越小越好，这样只要获取到数组中最小的三个数进行组合。
         *
         * 2、前面的数字越小，组成的数字就越小。而字符串的排序正好符合这个要求。
         *
         * （例：5，21，30——>21，30，5）
         */
    }
}
