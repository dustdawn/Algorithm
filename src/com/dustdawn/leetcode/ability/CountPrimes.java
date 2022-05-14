package com.dustdawn.leetcode.ability;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 *
 * @author dustdawn
 * @date 2022/4/17 14:20
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        // 质数的倍数不为质数
        boolean[] isPrime = new boolean[n];
        // 初始化均为质数
        Arrays.fill(isPrime, true);
        // 小于非负整数n，循环[2, sqrt(n))即可
        for (int i = 2; i * i < n; i++) {
            // 筛选法
            if (isPrimes(i)) {
                // 筛选质数的倍数: 2 * i, 3 * i, .., i * i, (i + 1) * i, ..
                // i * i前后的结果可能存在计算冗余，如 2 * 4 和 4 * 2
                // 只标记一遍，j从i的平方开始遍历，而不是2 * i开始
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 是否为质数 O(sqrt(n))
     *
     * @param n
     * @return
     */
    public static boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                // 有其他整除因子
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：n = 10
         * 输出：4
         * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
         * 示例 2：
         *
         * 输入：n = 0
         * 输出：0
         * 示例 3：
         *
         * 输入：n = 1
         * 输出：0
         */
    }
}
