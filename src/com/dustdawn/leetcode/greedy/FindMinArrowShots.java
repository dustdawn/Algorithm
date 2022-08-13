package com.dustdawn.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * 提示:
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -2^31 <= xstart < xend <= 2^31 - 1
 *
 * @author dustdawn
 * @date 2022/4/17 16:24
 */
public class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        return intervalSchedule(points);
    }

    /**
     * 区间intvs中互不相交区间的个数
     *
     * @param intvs
     * @return
     */
    public static int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        // 按终点结束最早的排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 直接相减整数范围溢出
                return o1[1] > o2[1] ? 1 : (o1[1] == o2[1] ? 0 : -1);
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排好序后，第一个区间为x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start > x_end) {
                // 该区间起点在x终点后，满足
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
         * 输出：2
         * 解释：气球可以用2支箭来爆破:
         * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
         * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
         * 示例 2：
         *
         * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
         * 输出：4
         * 解释：每个气球需要射出一支箭，总共需要4支箭。
         * 示例 3：
         *
         * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
         * 输出：2
         * 解释：气球可以用2支箭来爆破:
         * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
         * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
         */
        System.out.println(findMinArrowShots(new int[][]{new int[]{-2147483646, -2147483645}, new int[]{2147483646, 2147483647}}));
    }
}
