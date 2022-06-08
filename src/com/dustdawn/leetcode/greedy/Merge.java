package com.dustdawn.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @author dustdawn
 * @date 2022/4/17 16:20
 */
public class Merge {
    public static int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        // 根据区间的start升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 第一个区间的end
        int x_end = intervals[0][1];
        merged.add(intervals[0]);
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start > x_end) {
                // 不相交
                x_end = interval[1];
                merged.add(new int[]{start, x_end});
            } else {
                // 相交合并区间，合并后的end取这两个相交的区间end最大的
                x_end = Math.max(x_end, interval[1]);
                merged.get(merged.size() - 1)[1] = x_end;
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
         * 输出：[[1,6],[8,10],[15,18]]
         * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
         * 示例 2：
         *
         * 输入：intervals = [[1,4],[4,5]]
         * 输出：[[1,5]]
         * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
         */
        System.out.println(merge(new int[][]{new int[]{1, 4}, new int[]{4, 5}}));
        System.out.println(merge(new int[][]{new int[]{1, 4}, new int[]{0, 4}}));
        System.out.println(merge(new int[][]{new int[]{1, 4}, new int[]{0, 2}, new int[]{3, 5}}));
    }
}
