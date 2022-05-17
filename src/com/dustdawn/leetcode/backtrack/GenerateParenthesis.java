package com.dustdawn.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 提示：
 * 1 <= n <= 8
 *
 * @author dustdawn
 * @date 2022/5/17 21:46
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        backtrack(n, n, track, res);
        return res;
    }

    /**
     * 回溯算法框架
     * backtrack(路径，选择列表)
     * if 满足结束条件：result.add(路径) return
     * for 选择 in 选择列表
     * 做选择
     * backtrack(路径，选择列表)
     * 撤销选择
     * 解决一个回溯问题，实际上就是一个决策树的遍历过程，路径和选择列表视为决策树每个节点的熟悉，路径即是一个全排列
     *
     * @param left  可用的左括号数
     * @param right 可用的右括号数
     * @param track 每一个选择后遍历的组合结果
     * @param track
     */
    public static void backtrack(int left, int right, StringBuilder track, List<String> res) {
        if (left < 0 || right < 0) {
            // 有一方单独先用尽，不合法
            return;
        } else if (left > right) {
            // 做两次选择的情况，left <= right
            // 剩下左括号多，说明不合法
            return;
        } else if (left == 0 && right == 0) {
            // 所有括号都恰好用完，得到一个合法的括号组合
            res.add(track.toString());
            return;
        }
        // 做选择
        track.append("(");
        backtrack(left - 1, right, track, res);
        // 撤销选择
        track.deleteCharAt(track.length() - 1);

        // 做选择
        track.append(")");
        backtrack(left, right - 1, track, res);
        // 撤销选择
        track.deleteCharAt(track.length() - 1);
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：n = 3
         * 输出：["((()))","(()())","(())()","()(())","()()()"]
         * 示例 2：
         *
         * 输入：n = 1
         * 输出：["()"]
         */
    }
}
