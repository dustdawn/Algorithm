package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 分糖果(100分)(奇偶性)
 * 小明从糖果盒中随意抓一把糖果，每次小明会取出一半的糖果分给同学们。
 * 当糖果不能平均分配时，小明可以选择从糖果盒中（假设盒中糖果足够）取出一个糖果或放回一个糖果。
 * 小明最少需要多少次（取出、放回和平均分配均记一次），能将手中糖果分至只剩一颗。
 * 输入描述:
 * 抓取的糖果数（<10000000000）：
 * 15
 * 输出描述:
 * 最少分至一颗糖果的次数：
 * 5
 *
 * @author dustdawn
 * @date 2022/9/6 16:38
 */
public class F_Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n > 1) {
            if ((n & 1) != 0) {
                // n - 1 = 2时减1，或奇数越少时，次数越少
                if ((n - 1) / 2 == 1 || (n - 1) / 2 % 2 == 0) {
                    n--;
                } else {
                    n++;
                }
            } else {
                n /= 2;
                count++;
            }
        }
        System.out.println(count);
        /**
         * 示例1
         *
         * 输入
         *
         * 15
         *
         * 输出
         *
         * 5
         *
         * 备注:
         *
         * 解释：(1)15+1=16;(2)16/2=8;(3)8/2=4;(4)4/2=2;(5)2/2=1;
         */
    }
}
