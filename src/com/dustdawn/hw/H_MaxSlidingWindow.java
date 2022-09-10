package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 滑动窗口最大值(100分)(滑动窗口+双指针)
 * 题目描述：
 * 有一个N个整数的数组，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止，
 * 每次窗口滑动产生一个窗口和（窗口内所有数的和），求窗口滑动产生的所有窗口和的最大值。
 * 输入描述：
 * 第一行输入一个正整数N，表示整数个数。（0<N<100000）
 * 第二行输入N个整数，整数的取值范围为[-100,100]。
 * 第三行输入一个正整数M，M代表窗口的大小，M<=100000，且M<=N。
 * 输出描述：
 * 窗口滑动产生所有窗口和的最大值。
 *
 * @author dustdawn
 * @date 2022/9/3 20:22
 */
public class H_MaxSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        int len = Integer.parseInt(sc.nextLine());
        int res = 0;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += Integer.parseInt(str[r]);
            while (l <= r && r - l + 1 >= len) {
                res = Math.max(res, sum);
                sum -= Integer.parseInt(str[l++]);
            }
        }
        System.out.println(res);
        /**
         * 示例 1 输入输出示例仅供调试，后台判题数据一般不包含示例
         * 输入
         * 6
         * 12 10 20 30 15 23
         * 3
         * 输出
         * 68
         * 思路分析：
         * 这与leetcode的滑动窗口最大值不同，那个需要用单调栈来实现。计算每个窗口的最大值。
         * 这道题可以参考单调栈实现方法，用来统计滑动窗口的最大值。也可以使用双指针来实现。
         */
    }
}
