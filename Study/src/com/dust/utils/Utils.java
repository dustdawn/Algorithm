package com.dust.utils;

/**
 * @author dustdawn
 * @date 2019/8/1 23:03
 */
public class Utils {
    /**
     * char型数组交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * int型数组交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
