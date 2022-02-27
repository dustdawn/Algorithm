package com.dustdawn.leetcode.dp;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 提示：
 * 1 <= n <= 45
 *
 * @author dustdawn
 * @date 2022/2/27 15:05
 */
public class ClimbStairs {

    // private static Map<Integer, Integer> memo = new HashMap<>();

    public static int climbStairs(int n) {
        /**
         * 迭代解法
         */
        /*if (n <= 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, result);
        return result;*/
        /**
         * II.动态规划
         */
        // /**
        //  * 2.dp数组含义：dp[i]为剩余n个台阶时，有多少种方法可走完
        //  */
        // int[] dp = new int[n + 1];
        // /**
        //  * 1.base case
        //  */
        // dp[0] = 1;
        // // 剩余一个台阶时，只有一种方法
        // dp[1] = 1;
        // for (int i = 2; i < n + 1; i++) {
        //     /**
        //      * 3.状态转移方程
        //      */
        //     // 剩余i个台阶时，方法数为上一步走一步 和 上一步走两步的方法数之和
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];
        /**
         * III.优化解法
         */
        // dp[n]只和前两项dp[n]和dp[n-1]有关，和斐波那契额数列区别为的dp[0]和dp[1]均为1
        int a = 1;
        int b = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：n = 2
         * 输出：2
         * 解释：有两种方法可以爬到楼顶。
         * 1. 1 阶 + 1 阶
         * 2. 2 阶
         * 示例 2：
         *
         * 输入：n = 3
         * 输出：3
         * 解释：有三种方法可以爬到楼顶。
         * 1. 1 阶 + 1 阶 + 1 阶
         * 2. 1 阶 + 2 阶
         * 3. 2 阶 + 1 阶
         */
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
}
