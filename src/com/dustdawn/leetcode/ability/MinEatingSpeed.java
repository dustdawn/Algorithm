package com.dustdawn.leetcode.ability;

/**
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * 提示：
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * @author dustdawn
 * @date 2022/4/17 15:03
 */
public class MinEatingSpeed {
    /**
     * H小时内吃完香蕉的最小速率，速率为speed
     *
     * @param piles
     * @param h
     * @return
     */
    public static int minEatingSpeed(int[] piles, int h) {
        // speed最小为1，最大为max(piles)，穷举1到max(piles)即能找到最小速度
        // 线性搜索，用搜索左侧边界的二分搜索代替
        int left = 1;
        int right = getMax(piles);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // h小时按speed速度是否能否吃完
            if (canFinish(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * h小时按speed速度是否能否吃完poles O(N)
     *
     * @param piles
     * @param speed
     * @param h
     * @return
     */
    public static boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            // 用speed速度吃掉pile根香蕉的速度
            time += (pile / speed) + (pile % speed > 0 ? 1 : 0);
        }
        return time <= h;
    }

    public static int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入: piles = [3,6,7,11], H = 8
         * 输出: 4
         * 示例 2：
         *
         * 输入: piles = [30,11,23,4,20], H = 5
         * 输出: 30
         * 示例 3：
         *
         * 输入: piles = [30,11,23,4,20], H = 6
         * 输出: 23
         */
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}
