package com.dustdawn.leetcode.binarysearch;

/**
 * 367. 有效的完全平方数(简单)(锁定右边界二分搜索)
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * 提示：
 * 1 <= num <= 2^31 - 1
 *
 * @author dustdawn
 * @date 2022/9/12 14:46
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        int ans = -1;
        // 锁定右侧边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 防止整型溢出成负数
            long pow = (long) mid * mid;
            if (pow > num) {
                right = mid - 1;
            } else if (pow < num) {
                left = mid + 1;
                ans = mid;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }
        return ans * ans == num;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         * 输入：num = 16
         * 输出：true
         * 示例 2：
         * 输入：num = 14
         * 输出：false
         */
    }
}
