package com.dustdawn.leetcode.dp;

/**
 * 887. 鸡蛋掉落
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
 * 如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * 提示：
 * 1 <= k <= 100
 * 1 <= n <= 104
 *
 * @author dustdawn
 * @date 2022/8/8 17:20
 */
public class SuperEggDrop {
    public static int superEggDrop(int k, int n) {
        /**
         * dp(K, N)数组定义：给你K个鸡蛋面对N层楼时，最少扔几次。固定K时，函数随着N的增加单调递增
         * 分为碎了和没碎两种状态
         * dp(K, N) = min[0<=i<=N]{max{dp(K-1, i-1), dp(K, i+1)}}
         * 固定K和N，可以把函数dp(K-1, i-1)和dp(K, i+1)，其中i从1到N单调递增
         * 作为关于i的函数，前者随着i的增加单调递增，后者单调递减
         */
        // 具有单调性，可以运用二分搜索来优化线性搜索的复杂度，等价于求Valley山谷值
        /**
         * 2.dp数组：dp[k][m] = n表示当前有k个鸡蛋，最多可扔m次，在这个状态下，最坏情况最多可确切测试一栋n层的楼
         */
        int[][] dp = new int[k + 1][n + 1];
        /**
         * 1.base case
         * dp[0][...] = 0;
         * dp[...][0] = 0;
         */
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[dp[i].length];
        }
        int m = 0;
        /*
        题目为给定k个鸡蛋，n层楼，确定最坏情况下最少的测试次数m，m最大不会超过n（线性扫描）
        循环条件为dp[k][m] == n，也就是给k个鸡蛋，测试m次，最坏情况下最大测试N层楼
        通过循环找到m
         */
        while (dp[k][m] < n) {
            m++;
            for (int k0 = 1; k0 <= k; k0++) {
                /**
                 * 3.状态转移方程
                 * 鸡蛋碎了测楼下，没碎测楼上，无论上楼下楼，总层数 = 楼上层数 + 楼下层数 + 1（当前这层）
                 * 两种情况扔鸡蛋次数均-1
                 */
                dp[k0][m] = dp[k0][m - 1] + dp[k0 - 1][m - 1] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：k = 1, n = 2
         * 输出：2
         * 解释：
         * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
         * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
         * 如果它没碎，那么肯定能得出 f = 2 。
         * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
         * 示例 2：
         *
         * 输入：k = 2, n = 6
         * 输出：3
         * 示例 3：
         *
         * 输入：k = 3, n = 14
         * 输出：4
         */
        System.out.println(superEggDrop(2, 6));
    }
}
