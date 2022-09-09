package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 关联子串(100分)(字符串提取+排列组合匹配)
 * 给定两个字符串str1和str2，如果字符串str1中的字符，经过排列组合后的字符串中，只要有一个字符串是str2的子串，则认为str1是str2的关联子串。
 * 若str1是str2的关联子串，请返回子串在str2的起始位置；
 * 若不是关联子串，则返回-1。
 * 示例1：
 * 输入：str1="abc",str2="efghicabiii"
 * 输出：5
 * 解释：str2包含str1的一种排列组合（"cab")，此组合在str2的字符串起始位置为5（从0开始计数）
 * 示例2：str1="abc",str2="efghicaibii"
 * 输出：-1。
 * 预制条件：
 * 输入的字符串只包含小写字母；
 * 两个字符串的长度范围[1, 100,000]之间
 * 若str2中有多个str1的组合子串，请返回第一个子串的起始位置。
 * 输入描述:
 * 输入两个字符串，分别为题目中描述的str1、str2。
 * 输出描述:
 * 如果str1是str2的关联子串，则返回子串在str2中的起始位置。
 * 如果str1不是str2的关联子串，则返回-1。
 * 若str2中有多个str1的组合子串，请返回最小的起始位置。
 *
 * @author dustdawn
 * @date 2022/9/9 21:06
 */
public class G_SubString {
    public static boolean isFMatch(String str1, String str2) {
        int count = 0;
        int len = str1.length();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(str2.charAt(i));   //将需要匹配的字符串转换成列表
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (str1.charAt(i) == list.get(j)) {    //如果此字符串匹配成功
                    list.remove(j); //移除此字符串
                    count++;    //匹配成功次数加1
                    break;
                }
            }
        }
        if (count == len) { //如果匹配次数等于字符串长度则成功
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        String str1 = strings[0];
        String str2 = strings[1];
        int n1 = str1.length();
        int n2 = str2.length();
        int index = -1;

        for (int i = 0; i <= n2 - n1; i++) {
            if (isFMatch(str1, str2.substring(i, i + n1))) {  //将字符串2进行字符串1长度的切割
                index = i;
                break;
            }
        }

        System.out.println(index);

        /**
         * 示例1
         *
         * 输入
         *
         * abc efghicabiii
         *
         * 输出
         *
         * 5
         *
         * 说明
         *
         * str2包含str1的一种排列组合（"cab")，此组合在str2的字符串起始位置为5（从0开始计数）
         *
         * 示例2
         *
         * 输入
         *
         * abc efghicaibii
         *
         * 输出
         *
         * -1
         *
         * 说明
         *
         * “abc”字符串中三个字母的各种组合（abc、acb、bac、bca、cab、cba），str2中均不包含，因此返回-1
         *
         * 备注:
         *
         * 输入的字符串只包含小写字母；
         *
         * 两个字符串的长度范围[1, 100,000]之间
         */
    }
}
