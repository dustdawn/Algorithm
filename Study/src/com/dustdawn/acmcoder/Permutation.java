package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/14 16:21
 */

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * <p>
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation {
    public ArrayList<String> list = new ArrayList<>();
    public TreeSet<String> set = new TreeSet<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() > 9) {
            return null;
        }
        Permutation(str.toCharArray(), 0);
        list.addAll(set);
        return list;

    }

    public void swap(char[] ch, int i, int j) {

        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public void Permutation(char[] ch, int i) {
        if (ch == null || i < 0) {
            return;
        }
        //进行排列
        //固定第i个元素，排列后面元素，后面元素同样递归操作
        //出口：i为最后一个元素，后面无元素，无需进行深度递归，回溯回去
        if (i == ch.length - 1) {
            set.add(String.valueOf(ch));//去重
            return;
        }
        for (int j = i; j < ch.length; j++) {
            swap(ch, i, j);//1.依次将数组中每个元素换到固定元素的位置(i)
            Permutation(ch, i + 1);//2.将i后面的元素进行排列
            swap(ch, i, j);//回溯后还原原数组
        }
    }

    public static void main(String[] args) {
        Permutation o = new Permutation();
        System.out.println(o.Permutation("abcd").toString());
    }
}
