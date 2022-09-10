package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 叠积木(200分)(排序+dfs回溯)
 * 题目描述
 * 有一堆长方体积木，它们的长度和宽度都相同，但长度不一。
 * 小橙想把这堆积木叠成一面墙，墙的每层可以放一个积木，也可以将拼接多个积木，要求每层的长度相同。最少2层。
 * 若必须用完这些积木，叠成的墙最多为多少层？
 * 输入描述
 * 输入为一行，为各个积木的长度，数字为正整数，并由空格分隔。积木的数量和长度都不超过5000。
 * 输出描述
 * 输出一个数字，为墙的最大层数，如果无法按要求叠成每层长度一致的墙，则输出-1。
 *
 * @author dustdawn
 * @date 2022/9/4 17:11
 */
public class D_CanPartitionKSubsets {
    /**
     * 方案是否可划分
     *
     * @param nums  原数组
     * @param cur   当前入桶元素
     * @param used  使用元素个数
     * @param arr   分成的k个桶
     * @param k     桶的个数
     * @param score 每个桶平均大小
     * @return
     */
    public static boolean backtrack(int[] nums, int cur, int used, int[] arr, int k, int score) {
        if (cur < 0) {
            return true;
        }
        if (used < k) {
            arr[used] = nums[cur];
            // 是否可行
            if (backtrack(nums, cur - 1, used + 1, arr, k, score)) {
                return true;
            }
            arr[used] = 0;
        }
        // 遍历k个桶
        for (int i = 0; i < used; i++) {
            // 剪支
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] + nums[cur] <= score) {
                arr[i] += nums[cur];
                // 是否可行
                if (backtrack(nums, cur - 1, used, arr, k, score)) {
                    return true;
                }
                arr[i] -= nums[cur];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] nums = new int[str.length];
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
            sum += nums[i];
        }
        int res = -1;
        Arrays.sort(nums);
        for (int i = 2; i <= sum / 2; i++) {
            if (sum % i != 0) {
                continue;
            }
            int score = sum / i;
            if (nums[nums.length - 1] > score) {
                continue;
            }
            int[] arr = new int[i];
            // 填满加值后直接溢出score
            Arrays.fill(arr, score);
            if (backtrack(nums, nums.length - 1, 0, arr, i, score)) {
                res = Math.max(res, i);
            }
        }
        System.out.println(res);
        /**
         * 示例
         * 输入
         * 3 6 3 3 3
         * 输出
         * 3
         * 解释：以 6 为底的墙，第一层为 6 ，第二层为 3 + 3，第三层 3 + 3。
         * 输入
         * 9 9 9 5 3 2 2 2 2 2
         * 输出
         * 5
         * 解释：
         * 5+2+2=9
         * 3+2+2+2=9
         * 9,9,9
         * 共五层
         * 输入
         * 3 5
         * 输出
         * -1
         * 思路分析
         * 这道题要求每层的长度一样，且每层可以由多个积木拼接起来。
         * 这道题目考察了回溯法，可以参考leetcode:698. 划分为k个相等的子集。
         * 划分k个相同子集，就是保证每个子集都相同，总共划分k个。k就相当于我们的积木层数，子集就相当于我们一层积木的长度。
         * 因此我们只需要遍历层数，判断是否可以拼成，从第2层遍历到sum/2，对遍历的每一层，首先判断是否可以分配sum % i == 0
         * ，如果可以则回溯判断，同时更新最大层数。
         * 所以这道题的核心就是是否可以划分k个相同子集。
         */
    }
}
