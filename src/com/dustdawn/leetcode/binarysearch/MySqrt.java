package com.dustdawn.leetcode.binarysearch;

/**
 * 69. x 的平方根(简单)(锁定右边界二分搜索)
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 提示：
 * 0 <= x <= 231 - 1
 *
 * @author dustdawn
 * @date 2022/9/12 14:22
 */
public class MySqrt {
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        // 锁定右侧边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long pow = mid * mid;
            if (pow > x) {
                right = mid - 1;
            } else if (pow < x) {
                left = mid + 1;
                ans = mid;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         * 输入：x = 4
         * 输出：2
         * 示例 2：
         * 输入：x = 8
         * 输出：2
         * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
         */
        System.out.println(mySqrt(2147395599));
    }
}
