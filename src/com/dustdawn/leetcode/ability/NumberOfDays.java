package com.dustdawn.leetcode.ability;

/**
 * 1118. 一月有多少天
 * 提示：
 * 1. 1583 <= Y <= 2100
 * 2. 1 <= M <= 12
 *
 * @author dustdawn
 * @date 2022/5/11 21:54
 */
public class NumberOfDays {
    public static int numberOfDays(int Y, int M) {
        if (M != 2) {
            if (M < 8) {
                return M % 2 == 0 ? 30 : 31;
            } else {
                return M % 2 == 0 ? 31 : 30;
            }
        } else {
            if (Y % 100 == 0) {
                // 世纪年
                return Y % 400 == 0 ? 29 : 28;
            } else {
                // 普通年
                return Y % 4 == 0 ? 29 : 28;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 示例1 ：
         * 输入：Y = 1992, H = 7
         * 输出：31
         * 示例2:
         * 输入：Y = 2000, H = 2
         * 输出：29
         * 示例3:
         * 输入：Y = 1900, H = 2
         * 输出：28
         */
        System.out.println(numberOfDays(1992, 7));
        System.out.println(numberOfDays(2000, 2));
        System.out.println(numberOfDays(1900, 2));
    }
}
