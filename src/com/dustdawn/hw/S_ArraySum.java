package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 数组连续和(100分)(前缀和)
 * 题目描述
 * 给定一个含有N个正整数的数组, 求出有多少个连续区间（包括单个正整数）, 它们的和大于等于x。
 * 输入描述
 * 第一行两个整数N x（0 < N <= 100000, 0 <= x <= 10000000)
 * 第二行有N个正整数（每个正整数小于等于100)。
 * 输出描述
 * 输出一个整数，表示所求的个数。
 * 注意：此题对效率有要求，暴力解法通过率不高，请考虑高效的实现方式。
 *
 * @author dustdawn
 * @date 2022/9/6 20:33
 */
public class S_ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int preSum = 0;
            int minSum = 0;
            int maxSubSum = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                preSum += nums[j];
                maxSubSum = Math.max(maxSubSum, preSum - minSum);
                // System.out.println(maxSubSum);
                if (maxSubSum >= target) {
                    count++;
                }
                minSum = Math.min(minSum, preSum);
            }
        }
        System.out.println(count);

        /**
         * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
         *
         * 输入
         *
         * 3 7
         *
         * 3 4 7
         *
         * 输出
         *
         * 4
         *
         * 样例解释
         *
         * 第一行的3表示第二行数组输入3个数，第一行的7是比较数，用于判断连续数组是否大于该数；
         *
         * 组合为 3 + 4; 3 + 4 + 7; 4 + 7; 7; 都大于等于指定的7；所以共四组。
         *
         * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
         *
         * 10 10000
         *
         * 1 2 3 4 5 6 7 8 9 10
         *
         * 样例解释
         *
         * 所有元素的和小于10000，所以返回0。
         */
    }
}
