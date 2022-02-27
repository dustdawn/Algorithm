package com.dustdawn.leetcode.ability;

/**
 * 1281. 整数的各位积和之差
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 * @author dustdawn
 * @date 2022/2/27 16:39
 */
public class SubtractProductAndSum {
    public static int subtractProductAndSum(int n) {
        int add = 0;
        int mul = 1;
        // 取十位开始的每一位
        while (n != 0) {
            add += n % 10;
            mul *= n % 10;
            n = n / 10;
        }
        return mul - add;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：n = 234
         * 输出：15
         * 解释：
         * 各位数之积 = 2 * 3 * 4 = 24
         * 各位数之和 = 2 + 3 + 4 = 9
         * 结果 = 24 - 9 = 15
         * 示例 2：
         *
         * 输入：n = 4421
         * 输出：21
         * 解释：
         * 各位数之积 = 4 * 4 * 2 * 1 = 32
         * 各位数之和 = 4 + 4 + 2 + 1 = 11
         * 结果 = 32 - 11 = 21
         */
        System.out.println(subtractProductAndSum(234));
    }
}