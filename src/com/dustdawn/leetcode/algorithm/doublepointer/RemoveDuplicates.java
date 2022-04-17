package com.dustdawn.leetcode.algorithm.doublepointer;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。
 * 更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author dustdawn
 * @date 2022/4/17 16:01
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        // 有序数组原地删除
        // 慢指针slow在后，fast指针在前，找到不重复元素填到slow。fast遍历完数组时，nums[0, slow]就是不重复元素，之后都是重复元素
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < n) {
            // 因为有序，能找出所有重复项目
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [1,1,2]
         * 输出：2, nums = [1,2,_]
         * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
         * 示例 2：
         *
         * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
         * 输出：5, nums = [0,1,2,3,4]
         * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
         */
    }
}
