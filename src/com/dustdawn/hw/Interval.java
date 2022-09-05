package com.dustdawn.hw;

import java.util.*;

/**
 * 区间交集(200分)(并集+贪心合并空间)
 * 给定一组闭区间，其中部分区间存在交集。
 * 任意两个给定区间的交集，称为公共区间(如:[1,2],[2,3]的公共区间为[2,2]，[3,5],[3,6]的公共区间为[3,5])。
 * 公共区间之间若存在交集，则需要合并(如:[1,3],[3,5]区间存在交集[3,3]，需合并为[1,5])。
 * 按升序排列输出合并后的区间列表。
 * 输入描述
 * 一组区间列表，区间数为 N: 0<=N<=1000;区间元素为 X: -10000<=X<=10000。
 * 输出描述
 * 升序排列的合并区间列表
 * 备注
 * 1、区间元素均为数字，不考虑字母、符号等异常输入。
 * 2、单个区间认定为无公共区间。
 *
 * @author dustdawn
 * @date 2022/9/5 22:05
 */
public class Interval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 先计算交集
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            for (int j = i + 2; j < arr.length; j += 2) {
                int left = Math.max(arr[i], arr[j]);
                int right = Math.min(arr[i + 1], arr[j + 1]);
                if (left <= right) {
                    res.add(new int[]{left, right});
                }
            }
        }
        List<int[]> merged = new ArrayList<>();
        // 计算完交集，按从小到大排序，左边界升序，相同，有边界升序
        int[][] intervals = res.toArray(new int[res.size()][]);
        // 根据区间的start升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
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
        int[][] last = merged.toArray(new int[merged.size()][]);
        for (int i = 0; i < last.length; i++) {
            System.out.print(last[i][0]);
            System.out.print(" ");
            System.out.print(last[i][1]);
            if (i != last.length - 1) {
                System.out.print(" ");
            }
        }
        /**
         * 示例：
         * 输入
         * 1 3 2 4 4 8 5 9
         * 输出
         * 2 3 4 4 5 8
         * 说明
         * [1,3]、[2,4]、[4,8]、[5,9] 四个区间
         * [1,3]与[2,4]交集为[2,3]，[1,3]与[4,8]、[5,9]没有交集
         * [2,4]与[4,8]]交集为[4,4]。[2,4]与[5,9]没有交集
         * [4,8]与[5,9]的交集为[5,8]
         * 所以最终的输出为[2,3]、[4,4]、[5,8]
         * 输入
         * 1 6 2 5 5 7
         * 输出
         * 2 6
         * 说明
         * [1,6]、[2,5]的交集为[2,5]，[1,6]、[5,7]的交集为[5,6]
         * [2,5]、[5,7]的交集为[5,5]
         * 最后的输出为：2 6
         * 输入
         * 1 2 3 4
         * 输出
         * None  (这里没看到题目上具体要求输出什么，根据题目情况临场发挥即可)
         * 注：这道题目的输入输出有多个版本，有一行的，有分行的，有带中括号列表的，我是按一行读取，只是输入输出的不同而已，题目解法是一样的。
         *
         * 思路分析
         * 这道题目的要求简单的说就是当各个区间有交集的时候取交集，再求交集的并集。
         *
         * 求区间交集，双指针方法，可以参考leetcode：986. 区间列表的交集
         * 求区间并集，升序然后判断重叠，可以参考leetcode：56. 合并区间
         */
    }
}
