package com.dustdawn.leetcode.sort;

/**
 * 冒泡排序
 * 冒泡出最大的数至末尾
 * O(n^2) O(1) 稳定
 *
 * @author dustdawn
 * @date 2022/4/3 15:34
 */
public class BubbleSort extends Sort {
    public int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 相邻两数比较，每一轮将最大的数冒泡至末尾，N个数进行冒泡需要进行N-1轮比较
        // 标识每一轮是否有冒泡
        boolean flag = true;
        // 轮数为nums.length-1
        for (int i = 0; i < nums.length - 1 && flag; i++) {
            flag = false;
            // 升序排序中，每一轮会把最大的数冒泡至末尾，所以相互比较的次数，每一轮都会减少一次
            // 第i轮已冒泡i个数，待排序的即为[0, 轮数总数 - i]的子数组
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }
}
