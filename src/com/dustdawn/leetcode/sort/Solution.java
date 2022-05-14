package com.dustdawn.leetcode.sort;

import java.util.Arrays;

/**
 * @author dustdawn
 * @date 2022/4/3 15:50
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(new int[]{5, 6, 8, 2, 1, 4, 7, 3})));
        System.out.println(Arrays.toString(new SelectSort().selectSort(new int[]{5, 6, 8, 2, 1, 4, 7, 3})));
        System.out.println(Arrays.toString(new InsertSort().insertSort(new int[]{5, 6, 8, 2, 1, 4, 7, 3})));
        System.out.println(Arrays.toString(new ShellSort().shellSort(new int[]{5, 6, 8, 2, 1, 4, 7, 3})));
        System.out.println(Arrays.toString(new MergeSort().mergeSort(new int[]{5, 6, 8, 2, 1, 4, 7, 3})));
        System.out.println(Arrays.toString(new QuickSort().quickSort(new int[]{5, 6, 8, 2, 1, 4, 7, 3})));
    }
}
