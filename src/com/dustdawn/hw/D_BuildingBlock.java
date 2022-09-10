package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 叠积木(100分)(排序+dp最长递增子序列)
 * 题目描述
 * 给出一个列表如[[6,7,],[5,4],[3,2]],表示木块的长和宽，当木块的长和宽不大于另个木块的长和宽时，就可以放在上面，此外数组还可以左右翻转。求最多能搭多少层。
 * 输入描述
 * 一个二维数组，里面是每个积木的长和宽，可以左右翻转。
 * 输出描述
 * 最多能搭多少层。
 *
 * @author dustdawn
 * @date 2022/9/3 22:47
 */
public class D_BuildingBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("\\[", "").replaceAll("\\]", "");
        String[] s = str.split(",");
        int[][] nums = new int[s.length / 2][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new int[2];
            int a = Integer.parseInt(s[i * 2]);
            int b = Integer.parseInt(s[i * 2 + 1]);
            nums[i][0] = Math.max(a, b);
            nums[i][1] = Math.min(a, b);
        }
        // 先按长升序，再按宽升序
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        // 最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j][1] <= nums[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        /**
         * 样例
         * 输入
         * [[5,4],[6,3],[6,7],[6,6],[4,6]]
         * 输出
         * 4
         * 思路分析
         * 首先对输入的积木进行处理，统一大的做长放第一个位置，小的做宽放第二个位置。
         * 自定义排序，所有积木降序排，长度降序，相同则宽度降序。
         * 动态规划求最大。定义一个 dp 数组，dp[i] 表示如果积木为 i 时，最大积木层数。j 表示前 i - 1 个积木，
         * 如果前 i - 1 个积木中宽度大于当前积木，dp[i]就等于两者最大值，则状态转移方程：
         * if (nums[j][1] >= nums[i][1]) {
         * dp[i] = Math.max(dp[i], dp[j] + 1);  // 当前值，或从0到i-1中找到宽大于当前积木的
         * }
         *
         **/
    }

}
