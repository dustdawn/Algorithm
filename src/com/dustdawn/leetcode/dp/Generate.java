package com.dustdawn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 提示:
 * 1 <= numRows <= 30
 *
 * @author dustdawn
 * @date 2022/3/23 19:09
 */
public class Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> child = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j != 0 && j != i) {
                    /**
                     * 状态转移方程
                     * [1],
                     * [1,1],
                     * [1,2,1],
                     * [1,3,3,1],
                     * [1,4,6,4,1]
                     */
                    child.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                } else {
                    child.add(1);
                }
            }
            res.add(child);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: numRows = 5
         * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
         * 示例 2:
         *
         * 输入: numRows = 1
         * 输出: [[1]]
         */
        System.out.println(generate(5));
    }
}
