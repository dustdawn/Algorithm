package com.dustdawn.leetcode.ability;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * @author dustdawn
 * @date 2022/4/17 15:21
 */
public class MyPow {
    public static double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul(x, N) : (1.0 / quickMul(x, -N));
    }

    public static double quickMul(double x, long n) {
        if (n == 0) {
            return 1;
        }
        // a^b = a * a^(b - 1), b为奇数
        // a^b = (a^(b/2))^2, b为偶数数
        if (n % 2 == 1) {
            // n为奇数
            return x * quickMul(x, n - 1);
        } else {
            // n为偶数
            double sub = quickMul(x, n / 2);
            return sub * sub;
        }
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：x = 2.00000, n = 10
         * 输出：1024.00000
         * 示例 2：
         *
         * 输入：x = 2.10000, n = 3
         * 输出：9.26100
         * 示例 3：
         *
         * 输入：x = 2.00000, n = -2
         * 输出：0.25000
         * 解释：2-2 = 1/22 = 1/4 = 0.25
         */
    }
}
