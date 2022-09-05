package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数字涂色(100分)(排序+取模)
 * 题目描述
 * 疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。黑板上已经写上了N个正整数，同学们需要给这每个数分别上一种颜色。为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除。现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。
 * 输入描述
 * 第一行有一个正整数N，其中1≤N≤100。
 * 第二行有N个int型数(保证输入数据在[1,100]范围中)，表示黑板上各个正整数的值。
 * 输出描述
 * 输出只有一个整数，为最少需要的颜色种数。
 *
 * @author dustdawn
 * @date 2022/9/5 14:19
 */
public class DigitalPainting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        boolean[] s = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s[i]) {
                continue;
            } else {
                for (int j = i; j < n; j++) {
                    if (nums[j] % nums[i] == 0) {
                        s[j] = true;
                    }
                }
                res++;
            }
        }
        System.out.println(res);
        /**
         * 示例1
         * 输入
         * 3
         * 2 4 6
         * 输出
         * 1
         * 说明
         * 所有数都能被2整除。
         *
         * 示例2
         * 输入
         * 4
         * 2 3 4 9
         * 输出
         * 2
         * 说明
         * 2与4涂一种颜色，4能被2整除；3与9涂另一种颜色，9能被3整除。不能4个数涂同一个颜色，因为3与9不能被2整除。
         * 所以最少的颜色是两种。
         *
         * 思路分析
         * 这道题其实就是计算质数的个数。可以先排序，然后用一个布尔变量进行判断是否已经计算过
         */
    }

}
