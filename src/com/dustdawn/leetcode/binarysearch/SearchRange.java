package com.dustdawn.leetcode.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @author dustdawn
 * @date 2022/5/29 14:25
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{BinarySearch.leftSearch(nums, target), BinarySearch.rightSearch(nums, target)};
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [5,7,7,8,8,10], target = 8
         * 输出：[3,4]
         * 示例 2：
         *
         * 输入：nums = [5,7,7,8,8,10], target = 6
         * 输出：[-1,-1]
         * 示例 3：
         *
         * 输入：nums = [], target = 0
         * 输出：[-1,-1]
         */
    }
}
