package com.dustdawn.leetcode.datastructure;

import java.util.Stack;

/**
 * 503. 下一个更大元素 II(中等)(单调栈+取模)
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1 。
 * 提示:
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * @author dustdawn
 * @date 2022/6/6 20:23
 */
public class NextGreaterElements {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // 模拟数组长度翻倍
        // 倒序，保证翻倍后的最后一个元素(2 * n - 1)默认为-1，后续在n - 1位置进行更新
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            // 取模防止索引越界
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: nums = [1,2,1]
         * 输出: [2,-1,2]
         * 解释: 第一个 1 的下一个更大的数是 2；
         * 数字 2 找不到下一个更大的数；
         * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
         * 示例 2:
         *
         * 输入: nums = [1,2,3,4,3]
         * 输出: [2,3,4,-1,4]
         */
    }
}
