package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 停车场车辆统计(100分)(字符串分割+向上取整)
 * 题目描述：
 * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。
 * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。
 * 统计停车场最少可以停多少辆车，返回具体的数目。
 * 输入描述:
 * 整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
 * 输出描述：
 * 整型数字字符串，表示最少停车数目。
 *
 * @author dustdawn
 * @date 2022/9/5 15:01
 */
public class T_PrakingCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       /* String[] arr = sc.nextLine().replaceAll(",", "").split("0+");
        int sum = 0;
        for (String s : arr) {
            sum += (int) Math.ceil(s.length() * 1.0 / 3);
        }
        System.out.println(sum);*/

        String[] str = sc.nextLine().split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        String[] newStr = sb.toString().split("0");
        int count = 0;
        for (int i = 0; i < newStr.length; i++) {
            int length = newStr[i].length();
            if (length == 0) {
                continue;
            }
            if (length % 3 != 0) {
                count += (length - length % 3) / 3 + 1;
            } else {
                count += length / 3;
            }
        }
        System.out.println(count);
        /**
         * 示例 1：
         *
         * 输入
         * 1,0,1
         * 输出
         * 2
         * 说明
         * 1个小车占第1个车位
         * 第二个车位空
         * 1个小车占第3个车位
         * 最少有两辆车
         * 示例 2：
         *
         * 输入
         * 1,1,0,0,1,1,1,0,1
         * 输出
         * 3
         * 说明
         * 1个货车占第1、2个车位
         * 第3、4个车位空
         * 1个卡车占第5、6、7个车位
         * 第8个车位空
         * 1个小车占第9个车位
         * 最少3辆车
         */
    }
}
