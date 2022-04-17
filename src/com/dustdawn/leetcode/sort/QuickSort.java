package com.dustdawn.leetcode.sort;

/**
 * 快速排序
 * 原地分区，由上到下的，先分区，然后再处理子问题O(n * log2 n)
 *
 * @author dustdawn
 * @date 2022/4/3 17:32
 */
public class QuickSort extends Sort {
    public int[] quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] array, int start, int end) {
        if (array.length == 0 || start < 0 || end > array.length || start > end) {
            return;
        }
        // 以第一个元素为基准，两边分为大、小元素子数组，返回值为排序后的基数位置
        int baseIndex = partition(array, start, end);
        // 将分区后的两列迭代排序
        quickSort(array, start, baseIndex - 1);
        quickSort(array, baseIndex + 1, end);
    }

    public int partition(int[] array, int start, int end) {
        int base = array[start];
        while (start < end) {
            // 从后往前找到第一个小于base的元素
            while (start < end && array[end] >= base) {
                end--;
            }
            // 将找到的元素与start进行交换
            swap(array, start, end);

            //从前往后找到第一个大于base的元素
            while (start < end && array[start] <= base) {
                start++;
            }
            // 将找到的元素与end进行交换
            swap(array, start, end);
        }
        // 边界条件为start=end，返回基准最后放置的位置 array[start] = base;
        return start;
    }
}
