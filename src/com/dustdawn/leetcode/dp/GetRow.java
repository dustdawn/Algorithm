package com.dustdawn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 提示:
 * 0 <= rowIndex <= 33
 *
 * @author dustdawn
 * @date 2022/3/23 19:39
 */
public class GetRow {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> child = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j != 0 && j != i) {
                    child.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                } else {
                    child.add(1);
                }
            }
            list.add(child);
        }
        return list.get(rowIndex);
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: rowIndex = 3
         * 输出: [1,3,3,1]
         * 示例 2:
         *
         * 输入: rowIndex = 0
         * 输出: [1]
         * 示例 3:
         *
         * 输入: rowIndex = 1
         * 输出: [1,1]
         */
        System.out.println(getRow(0));
    }
}
