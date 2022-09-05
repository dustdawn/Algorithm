package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 猴子吃桃(200分)(二分法)
 * 题目描述：
 * 孙悟空喜欢吃蟠桃，一天他乘守卫蟠桃园的天兵天将离开了而偷偷的来到王母娘娘的蟠桃园偷吃蟠桃。
 * 已知蟠桃园有 N 棵蟠桃树，第 i 棵蟠桃树上有 N[i]（大于 0）个蟠桃，天兵天将将在 H（不小于蟠桃树棵数）小时后回来。
 * 孙悟空可以决定他吃蟠桃的速度 K（单位：个/小时），每个小时他会选择一颗蟠桃树，从中吃掉 K 个蟠桃，如果这棵树上的蟠桃数小于 K，他将吃掉这棵树上所有蟠桃，然后这一小时内不再吃其余蟠桃树上的蟠桃。
 * 孙悟空喜欢慢慢吃，但仍想在天兵天将回来前将所有蟠桃吃完。
 * 求孙悟空可以在 H 小时内吃掉所有蟠桃的最小速度 K（K 为整数）。
 * 输入描述:
 * 从标准输入中读取一行数字，前面数字表示每棵数上蟠桃个数，最后的数字表示天兵天将将离开的时间。
 * 输出描述：
 * 吃掉所有蟠桃的 最小速度 K（K 为整数）或 输入异常时输出 -1。
 *
 * @author dustdawn
 * @date 2022/9/5 14:54
 */
public class MonkeyEatPeach {

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
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] piles = new int[str.length - 1];
        for (int i = 0; i < str.length - 1; i++) {
            // 判断是否有异常输入,非数字
            for (int j = 0; j < str[i].length(); j++) {
                char ch = str[i].charAt(j);
                if (Character.isDigit(ch)) {
                    continue;
                } else {
                    System.out.println(-1);
                    return;
                }
            }
            piles[i] = Integer.parseInt(str[i]);
        }
        int h = Integer.parseInt(str[str.length - 1]);
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
        System.out.println(left);
        /**
         * 示例 1：
         *
         * 输入
         * 3 11 6 7 8
         * 输出
         * 4
         * 说明：
         * 天兵天将8个小时后回来，孙悟空吃掉所有蟠桃的最小速度4。
         *
         * 第1小时全部吃完第一棵树，吃3个，
         * 第2小时吃4个，第二棵树剩7个，
         * 第3小时吃4个，第二棵树剩3个，
         * 第4小时吃3个，第二棵树吃完，
         * 第5小时吃4个，第三棵树剩2个，
         * 第6小时吃2个，第三棵树吃完，
         * 第7小时吃4个，第4棵树剩3个，
         * 第8小时吃3个，第4棵树吃完。
         * 思路分析
         * 二分法的应用，找到满足条件的最小K。可以参考875. 爱吃香蕉的珂珂，原题。
         */
    }
}
