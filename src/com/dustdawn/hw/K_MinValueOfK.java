package com.dustdawn.hw;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * k 对元素最小值(100分)(优先队列)
 * 题目描述：
 * 给定两个整数数组array1 array2，数组元素按升序排列假设从arr1 arr2中分别取出一个元素，可构成一对元素。
 * 现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值。
 * 注意：两对元素对应arr1 arr2的下标是相同的视为同一对元素
 * 输入描述:
 * 输入两行数组arr1 arr2
 * 每行首个数字为数组大小size 0<size<=100
 * arr1，2中的每个元素 0<arr[i]<1000
 * 接下来一行 正整数k 0<k<=arr1.size * arr2.size
 * 输出描述：
 * 满足要求的最小值
 *
 * @author dustdawn
 * @date 2022/9/5 15:16
 */
public class K_MinValueOfK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str1 = in.nextLine().split(" ");
        int m = Integer.parseInt(str1[0]);
        int[] nums1 = new int[m];
        for (int i = 1; i < str1.length; i++) {
            nums1[i - 1] = Integer.parseInt(str1[i]);
        }
        String[] str2 = in.nextLine().split(" ");
        int n = Integer.parseInt(str2[0]);
        int[] nums2 = new int[n];
        for (int i = 1; i < str2.length; i++) {
            nums2[i - 1] = Integer.parseInt(str2[i]);
        }
        int k = in.nextInt();
        // 优先队列实现,小顶堆，总和小的排前
        int min = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
            }
        });
        // 把nums1索引加入队列
        for (int i = 0; i < Math.min(m, k); i++) {
            queue.add(new int[]{i, 0});
        }
        while (k > 0 && !queue.isEmpty()) {
            int[] idx = queue.poll();
            min += (nums1[idx[0]] + nums2[idx[1]]);
            // 为了避免重复，把nums2的索引增加
            // 11和22视为一对
            if (idx[1] + 1 < n) {
                queue.add(new int[]{idx[0], idx[1] + 1});
            }
            /*if (idx[0] + 1 < m) {
                queue.add(new int[]{idx[0] + 1, idx[1]});
            }*/
            k--;
        }
        System.out.println(min);
        /**
         * 示例 1：
         *
         * 输入
         * 3 1 1 2
         * 3 1 2 3
         * 2
         * 输出
         * 4
         * 说明
         * 用例中需要取两个元素，
         * 取第一个数组第0个元素与第二个数组第0个元素组成一个元素[1,1]
         * 取第一个数组第1个元素与第二个数组第0个元素组成一个元素[1,1]
         * 求和为1+1+1+1=4 ，满足要求最小
         */
    }
}
