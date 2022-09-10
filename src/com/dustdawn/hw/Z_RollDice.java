package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 转骰子(200分)(模拟)
 * 骰子是一个立方体，每个面一个数字，初始为左1，右2，前3（观察者方向），后4，上5，下6，用123456表示这个状态，放置到平面上，
 * 可以向左翻转（用L表示向左翻转1次），可以向右翻转（用R表示向右翻转1次），可以向前翻转（用F表示向前翻转1次），可以向后翻转（用B表示向后翻转1次），
 * 可以逆时针旋转（用A表示逆时针旋转90度），可以顺时针旋转（用C表示顺时针旋转90度），现从123456这个初始状态开始，根据输入的动作序列，计算得到最终的状态。
 * 骰子的初始状态和初始状态转动后的状态如图所示
 * 输入描述:
 * 输入一行，为只包含LRFBAC的字母序列，最大长度50，字母可重复
 * 输出描述:
 * 输出最终状态
 *
 * @author dustdawn
 * @date 2022/9/10 16:18
 */
public class Z_RollDice {

    public static String zhuanSZ(String s, String sz) {
        /**
         * 需要将char转成sting，否则会变成ASCII码值的和
         */
        String s1 = String.valueOf(sz.charAt(0));
        String s2 = String.valueOf(sz.charAt(1));
        String s3 = String.valueOf(sz.charAt(2));
        String s4 = String.valueOf(sz.charAt(3));
        String s5 = String.valueOf(sz.charAt(4));
        String s6 = String.valueOf(sz.charAt(5));

        /**
         * 骰子转向各个方向的重新排序
         */
        switch (s) {
            case "L":
                return s5 + s6 + s3 + s4 + s2 + s1;
            case "R":
                return s6 + s5 + s3 + s4 + s1 + s2;
            case "F":
                return s1 + s2 + s5 + s6 + s4 + s3;
            case "B":
                return s1 + s2 + s6 + s5 + s3 + s4;
            case "A":
                return s4 + s3 + s1 + s2 + s5 + s6;
            case "C":
                return s3 + s4 + s2 + s1 + s5 + s6;
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = "123456";  //骰子的初始状态
        for (int i = 0; i < s.length(); i++) {
            res = zhuanSZ(String.valueOf(s.charAt(i)), res);
        }
        System.out.println(res);
        /**
         * 示例1
         *
         * 输入
         *
         * LR
         *
         * 输出
         *
         * 123456
         *
         * 说明
         *
         * 骰子先向左翻转，再向右翻转回来，故还是原来的状态123456
         *
         * 示例2
         *
         * 输入
         *
         * FCR
         *
         * 输出
         *
         * 342156
         *
         * 说明
         *
         * 骰子向前翻转，状态变为125643，再顺时针旋转，状态变为651243，最后向右翻转，状态变为342156
         */
    }
}
