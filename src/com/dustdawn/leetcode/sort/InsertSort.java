package com.dustdawn.leetcode.sort;

/**
 * 插入排序
 * 将当前数插入到已排好序的部分的正确位置
 * O(n^2) O(1) 稳定
 *
 * @author dustdawn
 * @date 2022/4/3 16:16
 */
public class InsertSort extends Sort {
    public int[] insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 从i开始，往前找到第一个小于自己的数的索引index，插入到其后，原[index + 1, nums.length]的数后移
        // 循环次数nums.length - 1
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int preIndex;
            for (preIndex = i - 1; preIndex >= 0; preIndex--) {
                // nums[preIndex]小于当前数，preIndex对应的数后移
                if (current < nums[preIndex]) {
                    nums[preIndex + 1] = nums[preIndex];
                } else {
                    break;
                }
            }
            // 最后空出来的preIndex + 1即为当前值插入的地方
            nums[preIndex + 1] = current;
        }
        return nums;
    }
}
