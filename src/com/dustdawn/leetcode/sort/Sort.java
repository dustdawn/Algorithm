package com.dustdawn.leetcode.sort;

/**
 * @author dustdawn
 * @date 2022/4/3 15:42
 */
public class Sort {
    /**
     * 交换nums[i]和nums[j]的顺序
     *
     * @param nums
     * @param i
     * @param j
     * @return
     */
    protected int[] swap(int[] nums, int i, int j) {
        if (nums == null || i < 0 || j < 0 || i > nums.length - 1 || j > nums.length - 1) {
            return nums;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
