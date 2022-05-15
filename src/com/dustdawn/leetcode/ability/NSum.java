package com.dustdawn.leetcode.ability;

import java.util.LinkedList;
import java.util.List;

/**
 * n数之和
 * @author dustdawn
 * @date 2022/5/15 18:53
 */
public class NSum {
    /**
     * 找出nums（已排序）中n个数和为target的n元组
     *
     * @param nums
     * @param n
     * @param start
     * @param target
     * @return
     */
    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int length = nums.length;
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (n < 2 || length < n) {
            return res;
        }
        if (n == 2) {
            // 2Sum，双指针
            int l = start;
            int r = nums.length - 1;
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
        } else {
            for (int i = 0; i < length; i++) {
                List<List<Integer>> tuples = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                // 存在满足的n元组，加上nums[i]即为结果n元组
                for (List<Integer> tuple : tuples) {
                    tuple.add(nums[i]);
                    res.push(tuple);
                }
                // while跳过相同元素排除nums[i]的重复结果
                while (i < length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
