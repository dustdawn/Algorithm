package com.dustdawn.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @author dustdawn
 * @date 2022/5/30 21:26
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        // 记录路径
        List<Integer> track = new LinkedList<>();
        backtrack(res, nums, track);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, int[] nums, List<Integer> track) {
        // 到达递归树叶子节点
        if (track.size() == nums.length) {
            res.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 递归回溯
            backtrack(res, nums, track);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [1,2,3]
         * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
         * 示例 2：
         *
         * 输入：nums = [0,1]
         * 输出：[[0,1],[1,0]]
         * 示例 3：
         *
         * 输入：nums = [1]
         * 输出：[[1]]
         */
    }
}
