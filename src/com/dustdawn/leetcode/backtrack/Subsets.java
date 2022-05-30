package com.dustdawn.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author dustdawn
 * @date 2022/5/30 21:26
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 记录路径
        List<Integer> track = new ArrayList<>();
        backtrack(res, nums, 0, track);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, int[] nums, int start, List<Integer> track) {
        // 前序遍历位置记录所有递归树的节点
        res.add(new ArrayList<Integer>(track));
        // 从start开始，防止产生重复的子集。即遍历以start开头的子集
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 递归回溯
            backtrack(res, nums, i + 1, track);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [1,2,3]
         * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
         * 示例 2：
         *
         * 输入：nums = [0]
         * 输出：[[],[0]]
         */
    }
}
