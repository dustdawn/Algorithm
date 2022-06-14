package com.dustdawn.leetcode.dp;

/**
 * 651. 4键键盘
 * 假设你有一个特殊的键盘包含下面的按键：
 * Key 1: (A)：在屏幕上打印一个 'A'。
 * Key 2: (Ctrl-A)：选中整个屏幕。
 * Key 3: (Ctrl-C)：复制选中区域到缓冲区。
 * Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
 * 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A’呢？
 * 注释:
 * 1 <= N <= 50
 * 结果不会超过 32 位有符号整数范围。
 *
 * @author dustdawn
 * @date 2022/6/14 20:46
 */
public class MaxA {
    public static int maxA(int n) {
        /*
        由于敲击键盘改变的三个量即为三个状态：剩余的按键次数，当前屏幕上字符A的个数，剪贴板中字符A的个数
        最优情况下，最后一次按键应该为操作A或操作CV，选择减少为两个
         */
        /**
         * 2.dp数组：dp[i]表示i次操作后最多显示A的个数
         */
        int[] dp = new int[n + 1];
        /**
         * 1.base case
         */
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            /**
             * 3.状态转移方程
             * 第i次为操作A，就是状态i - 1的屏幕上新增一个A；
             * 为CV，取决于剪贴板A的数量，则剪贴板的数量取决于上一次CA CC的时机
             * 用j表示上一次按完CA CC的时机，此时剪贴板中A的个数就是dp[j - 2]。j穷举得出
             */
            // 按A键
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 全选并复制dp[j - 2]，连续粘贴i - j次
                // 屏幕上共dp[j - 2] * (i - j + 1)个A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        /**
         * 样例 1:
         * 输入: N = 3
         * 输出: 3
         * 解释:
         * 我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
         * A, A, A
         *
         * 样例 2:
         * 输入: N = 7
         * 输出: 9
         * 解释:
         * 我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
         * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
         */
        System.out.println(maxA(3));
        System.out.println(maxA(7));
    }

}
