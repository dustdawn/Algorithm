package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 机智的外卖员(dp)
 * 题目描述：
 * 外卖员每天在大厦中送外卖，大厦共有L层（0<L<=10^5），当他处于第N层楼时，可以每分钟通过步行梯向上达到N+1层，
 * 或向下达到N-1层，或者乘坐电梯达到2*N层。给定他所处位置N，以及外卖配送的目的楼层M，计算他送达的最短时间。
 * 输入描述
 * 当前所处楼层N和外卖配送的目的楼层M
 * 输出描述
 * 送达的最短时间
 *
 * @author dustdawn
 * @date 2022/9/3 22:32
 */
public class WittyDeliveryMan {
    /**
     * 样例
     * 输入
     * 5 17
     * 输出
     * 4
     * 思路分析
     * 这道题是一道动态规划问题，dp[i]表示到达第i层的最短时间。
     * 初始化的时候，到N层以下需要的时间，都减去相应的楼层，即步行向下
     * for (int i = 0; i <= N; i++) {  // 初始化到N层以下需要的时间
     * dp[i] = N - i;
     * }
     * 转移方程为，走步行梯都是dp[i - 1] + 1，走电梯需要判断是偶数层，如果是偶数层，则dp[i / 2] + 1，
     * 如果是奇数层，则dp[(i + 1) / 2] + 2，选择走步行梯和电梯时间最短的。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // dp[i]为到达第i层的时间
        int[] dp = new int[m + 1];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = n - i;
        }
        for (int i = n + 1; i < dp.length; i++) {
            // 走楼梯
            dp[i] = dp[i - 1] + 1;
            // 为奇数
            if ((i & 1) != 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 2);
            } else {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[m]);
    }
}
