package com.dustdawn.leetcode.ability;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * 提示：
 * 3 <= salary.length <= 100
 * 10^3 <= salary[i] <= 10^6
 * salary[i]是唯一的。
 * 与真实值误差在 10^-5 以内的结果都将视为正确答案。
 *
 * @author dustdawn
 * @since 2022/2/26 16:30
 */
public class Average {
    public static double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double res = 0;
        for (int j : salary) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
            res += j;
        }
        return (res - max - min) / (salary.length - 2);
    }

    public static void main(String[] args) {
        /*
         * 示例 1：
         * <p>
         * 输入：salary = [4000,3000,1000,2000]
         * 输出：2500.00000
         * 解释：最低工资和最高工资分别是 1000 和 4000 。
         * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
         * 示例 2：
         * <p>
         * 输入：salary = [1000,2000,3000]
         * 输出：2000.00000
         * 解释：最低工资和最高工资分别是 1000 和 3000 。
         * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
         */
        System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
        System.out.println(average(new int[]{1000, 2000, 3000}));
    }
}
