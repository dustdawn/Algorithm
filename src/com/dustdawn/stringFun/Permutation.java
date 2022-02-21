package com.dustdawn.stringFun;

import com.dustdawn.utils.Utils;

/**
 * @author dustdawn
 * @date 2019/8/1 23:02
 * <p>
 * 求一个字符串的所有排列（递归）时间复杂度n!
 */
public class Permutation {

    public static void permutation(String str) {
        char arr[] = str.toCharArray();
        permutation(arr, 0);
    }

    //思路：确定第一个位置的字符，然后分别与后面的字符进行交换
    //出口：直到与末尾元素交换
    public static void permutation(char[] arr, int start) {
        if (arr == null || start < 0) {
            return;
        }
        //到末尾
        if (start == arr.length - 1) {
            System.out.println(arr);
        } else {

            for (int i = start; i < arr.length; i++) {
                Utils.swap(arr, start, i);
                permutation(arr, start + 1);
                Utils.swap(arr, start, i);//还原
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        permutation(s);
    }
}
