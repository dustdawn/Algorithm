package com.dustdawn.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * @author dustdawn
 * @date 2022/8/8 11:39
 */
public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return res;
        }
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, track, res);
        return res;
    }

    public static void backtrack(int n, int k, int start, List<Integer> track, List<List<Integer>> res) {
        // 全部选完
        if (k == track.size()) {
            res.add(new ArrayList<Integer>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 做选择
            track.add(i);
            // 递归回溯
            backtrack(n, k, i + 1, track, res);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：n = 4, k = 2
         * 输出：
         * [
         *   [2,4],
         *   [3,4],
         *   [2,3],
         *   [1,2],
         *   [1,3],
         *   [1,4],
         * ]
         * 示例 2：
         *
         * 输入：n = 1, k = 1
         * 输出：[[1]]
         */
        System.out.println(combine(4, 2));
    }
}
