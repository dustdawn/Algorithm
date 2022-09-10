package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 数组求和(100分)(数组+模拟)
 * 题目描述：
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 * 说明:
 * 数组中数字范围[0, 1000]
 * 最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
 * 输入非法返回-1
 * 输入描述：
 * 第一行输入M， M标识数组大小
 * 第二行输入M个数，标识数组内容
 * 第三行输入N，N表达需要计算的最大、最小N个数
 * 输出描述：
 * 输出最大N个数与最小N个数的和。
 *
 * @author dustdawn
 * @date 2022/9/5 16:49
 */
public class S_ArraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // TreeSet
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        int N = in.nextInt();
        Collections.sort(list);
        if (list.size() < 2 * N) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (list.get(i) + list.get(list.size() - 1 - i));
        }
        System.out.println(sum);
        /**
         * 示例 1：
         *
         * 输入
         * 5
         * 95 88 83 64 100
         * 2
         * 输出
         * 342
         * 说明
         * 最大2个数[100,95],最小2个数[83,64], 输出为342
         *
         * 示例 2：
         *
         * 输入
         * 5
         * 3 2 3 4 2
         * 2
         * 输出
         * -1
         * 说明
         * 最大2个数[4,3],最小2个数[3,2], 有重叠输出为-1
         */
    }
}
