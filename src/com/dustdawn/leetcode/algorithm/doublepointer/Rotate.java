package com.dustdawn.leetcode.algorithm.doublepointer;

/**
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @author dustdawn
 * @date 2022/2/27 17:40
 */
public class Rotate {
    public static void rotate(int[] nums, int k) {
        /**
         * I.增加数组
         */
        /*int[] res = new int[nums.length];
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            res[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }*/
        /**
         * II.全部反转后以k取余nums.length的位置为中心，两边同时反转
         */
        swapArray(nums, 0, nums.length - 1);
        swapArray(nums, 0, k % nums.length - 1);
        swapArray(nums, k % nums.length, nums.length - 1);
    }

    /**
     * 将数组arrs从i到j反转
     *
     * @param arrs
     * @param i
     * @param j
     */
    public static void swapArray(int[] arrs, int i, int j) {
        int temp;
        for (; i < j; i++, j--) {
            temp = arrs[i];
            arrs[i] = arrs[j];
            arrs[j] = temp;
        }
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: nums = [1,2,3,4,5,6,7], k = 3
         * 输出: [5,6,7,1,2,3,4]
         * 解释:
         * 向右轮转 1 步: [7,1,2,3,4,5,6]
         * 向右轮转 2 步: [6,7,1,2,3,4,5]
         * 向右轮转 3 步: [5,6,7,1,2,3,4]
         * 示例 2:
         *
         * 输入：nums = [-1,-100,3,99], k = 2
         * 输出：[3,99,-1,-100]
         * 解释:
         * 向右轮转 1 步: [99,-1,-100,3]
         * 向右轮转 2 步: [3,99,-1,-100]
         */
    }
}
