package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 玩牌高手(100分)(数组+模拟)
 * 题目描述：
 * 给定一个长度为n的整型数组，表示一个选手在n轮内可选择的牌面分数。选手基于规则选牌，请计算所有轮结束后其可以获得的最高总分数。
 * 选择规则如下：
 * 在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数，为其新的总分数。
 * 选手也可不选择本轮牌面直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，若当前轮次小于等于3（即在第1、2、3轮选择跳过轮次），则总分数置为0。
 * 选手的初始总分数为0，且必须依次参加每一轮。
 * 输入描述
 * 第一行为一个小写逗号分割的字符串，表示n轮的牌面分数，1<= n <=20。
 * 分数值为整数，-100 <= 分数值 <= 100。
 * 不考虑格式问题。
 * 输出描述
 * 所有轮结束后选手获得的最高总分数。
 *
 * @author dustdawn
 * @date 2022/9/5 16:33
 */
public class W_PlayerOfTop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int[] score = new int[str.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 3) {
                if (nums[i] <= 0) {
                    score[i] = 0;
                } else {
                    score[i] = sum + nums[i];
                }
            } else {
                if (nums[i] > 0) {
                    score[i] = sum + nums[i];
                } else {
                    score[i] = Math.max(sum + nums[i], score[i - 3]);
                }
            }
            sum = score[i];
        }
        System.out.println(score[str.length - 1]);
        /**
         * 示例 1：
         * 输入
         * 1,-5,-6,4,3,6,-2
         * 输出
         * 11
         * 说明
         * 总共有7轮牌面。
         * 第一轮选择该轮牌面，总分数为1。
         * 第二轮不选择该轮牌面，总分数还原为0。
         * 第三轮不选择该轮牌面，总分数还原为0。
         * 第四轮选择该轮牌面，总分数为4。
         * 第五轮选择该轮牌面，总分数为7。
         * 第六轮选择该轮牌面，总分数为13。
         * 第七轮如果不选择该轮牌面，则总分数还原到3轮1前分数，即第四轮的总分数4，如果选择该轮牌面，总分数为11，所以选择该轮牌面。
         * 因此，最终的最高总分为11。
         * 思路分析
         * 简单的模拟题。按规则走就行了。
         */
    }
}
