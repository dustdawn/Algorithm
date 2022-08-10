package com.dustdawn.leetcode.ability;

import java.util.Arrays;

/**
 * 372. 超级次方
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 提示：
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 *
 * @author dustdawn
 * @date 2022/4/17 14:38
 */
public class SuperPow {
    public static int superPow(int a, int[] b) {
        if (b == null || b.length == 0) {
            return 1;
        }
        // a^b = a^(b%10) * (a^(b/10))^10，如a^1234 = a^4 * (a^123)^10
        int[] temp = Arrays.copyOfRange(b, 0, b.length - 1);
        // 取出最后一个数
        int last = b[b.length - 1];
        // a^(b%10)
        int part1 = mypow(a, last);
        // (a^(b/10))^10
        int part2 = mypow(superPow(a, temp), 10);
        // 可证明式：(a * b) % c = (a % c)(b % c) % c
        // 即对乘法的结果求模，等价于先对每个因子求模，然后对因子相乘的结果再求模
        return (part1 * part2) % 1337;
    }

    /**
     * 计算a的k次方然后与1337求模的结果
     */
    public static int mypow(int a, int k) {
        a %= 1337;
        int res = 1;
        // 一个数的幂即为连乘，连乘与1337求模也为每个因子单独求模的结果相乘
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= 1337;
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：a = 2, b = [3]
         * 输出：8
         * 示例 2：
         *
         * 输入：a = 2, b = [1,0]
         * 输出：1024
         * 示例 3：
         *
         * 输入：a = 1, b = [4,3,3,8,5,2]
         * 输出：1
         * 示例 4：
         *
         * 输入：a = 2147483647, b = [2,0,0]
         * 输出：1198
         */
        System.out.println(superPow(2147483647, new int[]{2, 0, 0}));
    }
}
