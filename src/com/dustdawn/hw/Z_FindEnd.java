package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 找终点(100分)(数组+滑动窗口)
 * 题目描述
 * 给定一个正整数数组，设为nums，最大为100个成员，求从第一个成员开始，正好走到数组最后一个成员，所使用的最少步骤数。
 * 要求：
 * 第一步必须从第一元素开始，且1<=第一步的步长<len/2;（len为数组的长度，需要自行解析）。
 * 从第二步开始，只能以所在成员的数字走相应的步数，不能多也不能少, 如果目标不可达返回-1，只输出最少的步骤数量。
 * 只能向数组的尾部走，不能往回走。
 * 输入描述:
 * 由正整数组成的数组，以空格分隔，数组长度小于100，请自行解析数据数量。
 * 输出描述:
 * 正整数，表示最少的步数，如果不存在输出-1
 *
 * @author dustdawn
 * @date 2022/9/6 14:35
 */
public class Z_FindEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        //进度
        int step = 0;
        // 步数
        int count = 0;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length / 2 - 1; i++) {
            step = i;
            count = 1;
            // 没有走完继续
            while (step < nums.length - 1) {
                step += nums[step];
                count++;
            }
            if (step == nums.length - 1) {
                max = Math.min(max, count);
            }
        }
        if (max == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(max);
        }
        /**
         * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
         *
         * 输入
         *
         * 7 5 9 4 2 6 8 3 5 4 3 9
         *
         * 输出
         *
         * 2
         *
         * 说明
         *
         * 第一步： 第一个可选步长选择2，从第一个成员7开始走2步，到达9；
         *
         * 第二步： 从9开始，经过自身数字9对应的9个成员到最后。
         *
         * 示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
         *
         * 输入
         *
         * 1 2 3 7 1 5 9 3 2 1
         *
         * 输出
         *
         * -1
         */
    }
}
