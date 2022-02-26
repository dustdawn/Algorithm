package com.dustdawn.leetcode.algorithm.binarysearch;

/**
 * 704. 二分查找
 * 给定一个 mid 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @author dustdawn
 * @date 2022/2/26 16:48
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // left + right 可能越界
        // int mid = (left + right) / 2;
        // int mid = left  - left / 2 + right / 2
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 锁定左侧边界
     * [left, mid)和[mid + 1, right)取前者
     *
     * @param left
     * @param right
     * @param nums
     * @param target
     * @return
     */
    public static int leftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 锁定左侧，收缩右侧（right = mid - 1）
                right = mid - 1;
            }
        }
        // 退出条件为 left = right - 1，即
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 锁定右侧边界
     *
     * @param left
     * @param right
     * @param nums
     * @param target
     * @return
     */
    public static int rightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 锁定右侧，收缩左侧（left = mid + 1）
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: nums = [-1,0,3,5,9,12], target = 9
         * 输出: 4
         * 解释: 9 出现在 nums 中并且下标为 4
         * 示例 2:
         *
         * 输入: nums = [-1,0,3,5,9,12], target = 2
         * 输出: -1
         * 解释: 2 不存在 nums 中因此返回 -1
         */
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
