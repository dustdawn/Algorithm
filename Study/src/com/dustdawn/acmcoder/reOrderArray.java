package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/4 10:11
 */

import java.util.Arrays;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class reOrderArray {

    //遍历数组，使用新空间保存，奇数从前往后插入，偶数从后往前插入
    //最后反转偶数部分保证相对位置不变O(n)
    public static void reOrderArray(int[] array) {
        int[] re = new int[array.length];
        int j = 0;
        int k = re.length - 1;
        for (int i = 0; i < array.length && j <= k; i++) {
            if (array[i] % 2 != 0) {
                re[j] = array[i];
                ++j;
            }else {
                re[k] = array[i];
                --k;
            }
        }
        //反转j到末尾元素部分数组
        reverse(re, j, re.length-1);

        System.arraycopy(re, 0, array, 0, re.length);
        System.out.println(Arrays.toString(array));

    }

    //插入排序思想实现，利用插入排序的稳定性O(n^2)
    public static void insertOrder(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int preIndex = i;
            int current = array[i+1];
            //将前半部分当做已排列
            //如果当前元素为奇数且前一元素为偶数，则插入到最近奇数的后面
            while (preIndex >= 0 && array[preIndex] % 2 == 0 && current % 2 == 1) {
                array[preIndex + 1] = array[preIndex];
                --preIndex;
            }
            array[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] a = {8,6,5,2,1,3,4,7};
        //int a[] = {1,2,3,4,5,6,7};
        reOrderArray(a);
        insertOrder(a);
    }
}
