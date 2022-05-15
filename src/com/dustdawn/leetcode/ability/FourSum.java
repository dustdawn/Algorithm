package com.dustdawn.leetcode.ability;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * @author dustdawn
 * @date 2022/5/15 18:34
 */
public class FourSum {
    /**
     * 计算数组nums中所有和为target的三元组
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSumTarget(int[] nums, int target) {
        // 排序后进行双指针
        Arrays.sort(nums);
        int n = nums.length;
        LinkedList<List<Integer>> res = new LinkedList<>();
        // 穷举fourSum的第一个数
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = threeSumTarget(nums, i + 1, target - nums[i]);
            // 存在满足的三元组，加上nums[i]即为结果四元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.push(tuple);
            }
            // while跳过相同元素排除nums[i]的重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    /**
     * 计算数组nums中所有和为target的三元组
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
        // 此处nums无需排序，且从start，其他不变
        // Arrays.sort(nums);
        int n = nums.length;
        LinkedList<List<Integer>> res = new LinkedList<>();
        // 穷举threeSum的第一个数
        for (int i = start; i < n; i++) {
            List<List<Integer>> tuples = ThreeSum.twoSumTarget(nums, i + 1, target - nums[i]);
            // 存在满足的二元组，加上nums[i]即为结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.push(tuple);
            }
            // while跳过相同元素排除nums[i]的重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 提示：
         *
         * 1 <= nums.length <= 200
         * -109 <= nums[i] <= 109
         * -109 <= target <= 109
         */
    }
}
