package com.dustdawn.leetcode.sort;

/**
 * 简单选择排序
 * 选择出最小的比较
 * O(n^2) O(1) 不稳定
 *
 * @author dustdawn
 * @date 2022/4/3 15:56
 */
public class SelectSort extends Sort {
    public int[] selectSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        // 每一轮都选择出最小的数，从前往后排
        for (int i = 0; i < nums.length - 1; i++) {
            // 第i轮从未排好序的[i + 1, nums.length - 1]范围中选出最小数，与nums[i]进行交换
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(nums, i, minIndex);
            }
        }
        return nums;
    }
}
