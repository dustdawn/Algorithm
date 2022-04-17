package com.dustdawn.leetcode.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 分治思想，分而治之。自下而上，先处理子问题，然后再合并，将小集合合成大集合O(n * log2 n)
 *
 * @author dustdawn
 * @date 2022/4/3 17:12
 */
public class MergeSort extends Sort {
    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        // 1.分
        // 复制数组，分组0到mid - 1，nums.length - 1
        int left[] = Arrays.copyOfRange(nums, 0, mid);
        int right[] = Arrays.copyOfRange(nums, mid, nums.length);
        // 2.治 归并后的数组
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
		/*  8 4 5 7 1 3 6 2
	      8 4 5 7	    1 3 6 2
		8 4     5 7   															分
	   8   4   5 	7		 ------------------------------------
	  	4 8     5 7																治
	      4 5 7 8
	   		1 2 3 4 5 6 7 8
		*/
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                // 表示若执行第四个判断left到末尾(所有元素归并到result内)，将right元素归并到result即可
                result[index] = right[j++];
            } else if (j >= right.length) {
                // 表示若执行第三个判断right到末尾(所有元素归并到result内)，将left元素归并到result即可
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                // 第一组中的第i个数比较第二组第j个数
                // 则赋值result第index个元素为两组中小的数
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }
}
