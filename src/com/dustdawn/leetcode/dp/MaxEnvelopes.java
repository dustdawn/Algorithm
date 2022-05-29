package com.dustdawn.leetcode.dp;

import com.dustdawn.leetcode.binarysearch.LengthOfLIS;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 * 提示：
 * 1 <= envelopes.length <= 105
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 105
 *
 * @author dustdawn
 * @date 2022/5/29 15:00
 */
public class MaxEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        /*
        两个wi相同的信封不能相互包含，wi相同时，将hi逆序，则逆序的hi中最多只会有一个被选入递增子序列
         */
        Arrays.sort(envelopes, new Comparator<int[]>() {
            // 按宽度升序排列，宽度一样按照高度降序排列
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        // 对高度数组寻找LIS(最长递增子序列)
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return LengthOfLIS.lengthOfLIS(height);
    }

    public static void main(String[] args) {
        /**
         *  
         * 示例 1：
         *
         * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
         * 输出：3
         * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
         * 示例 2：
         *
         * 输入：envelopes = [[1,1],[1,1],[1,1]]
         * 输出：1
         */
    }
}
