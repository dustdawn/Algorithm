package com.dustdawn.leetcode.ability;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * @author dustdawn
 * @date 2022/5/15 17:46
 */
public class ThreeSum {

    /**
     * 从nums[start]开始，计算有序数组nums中所有和为target的二元组
     *
     * @param nums
     * @param start
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // 排序后进行双指针
        int l = start;
        int r = nums.length - 1;
        LinkedList<List<Integer>> res = new LinkedList<>();
        while (l < r) {
            int left = nums[l];
            int right = nums[r];
            int sum = left + right;
            // while跳过相同元素
            if (sum < target) {
                while (l < r && nums[l] == left) {
                    l++;
                }
            } else if (sum > target) {
                while (l < r && nums[r] == right) {
                    r--;
                }
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(left);
                list.add(right);
                res.push(list);
                while (l < r && nums[l] == left) {
                    l++;
                }
                while (l < r && nums[r] == right) {
                    r--;
                }
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
    public static List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // 排序后进行双指针
        Arrays.sort(nums);
        int n = nums.length;
        LinkedList<List<Integer>> res = new LinkedList<>();
        // 穷举threeSum的第一个数
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
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

    public static List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums, 0);
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [-1,0,1,2,-1,-4]
         * 输出：[[-1,-1,2],[-1,0,1]]
         * 示例 2：
         *
         * 输入：nums = []
         * 输出：[]
         * 示例 3：
         *
         * 输入：nums = [0]
         * 输出：[]
         */
    }
}
