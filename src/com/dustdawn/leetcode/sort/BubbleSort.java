package com.dustdawn.leetcode.sort;

/**
 * 冒泡排序
 * 冒泡出最大的数至末尾O(n^2)
 *
 * @author dustdawn
 * @date 2022/4/3 15:34
 */
public class BubbleSort extends Sort {
    public int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        // 相邻两数比较，每一轮将最大的数冒泡至末尾
        // 标识每一轮是否有冒泡
        boolean flag = true;
        for (int i = 0; i < nums.length && flag; i++) {
            flag = false;
            // 第i轮已冒泡i + 1个数，待排序的即为[0, nums.length - i]的子数组
            // 相邻两数比较，边界即为nums.length - i - 1
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
        }
        return nums;
    }
}
