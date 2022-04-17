package com.dustdawn.leetcode.sort;

/**
 * 希尔排序
 * 跨度分组插入排序O(n * log2 n)
 *
 * @author dustdawn
 * @date 2022/4/3 16:37
 */
public class ShellSort extends Sort {
    public int[] shellSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int increment = nums.length;
        while (increment > 1) {
            // 初始化跨度为长度一半
            increment /= 2;
            // n为每组的增量数
            for (int n = 0; n < increment; n++) {
                // 相当于原快速排序一组的0 + 1和i - 1
                for (int i = n + increment; i < nums.length; i += increment) {
                    int current = nums[i];
                    int preIndex;
                    for (preIndex = i - increment; preIndex >= 0; preIndex -= increment) {
                        if (current < nums[preIndex]) {
                            nums[preIndex + increment] = nums[preIndex];
                        } else {
                            break;
                        }
                    }
                    nums[preIndex + increment] = current;
                }
            }
        }
        return nums;
    }
}
