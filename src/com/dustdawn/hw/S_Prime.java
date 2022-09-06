package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 素数之积(100分)(质数计算)
 * RSA加密算法在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全系数越高，给定一个32位正整数，
 * 请对其进行因数分解，找出是哪两个素数的乘积。
 * 输入描述:
 * 一个正整数num
 * 0 < num <= 2147483647
 * 输出描述:
 * 如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1 -1
 *
 * @author dustdawn
 * @date 2022/9/6 21:23
 */
public class S_Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int m = 0;
        /**
         * 本题就是求出一个数只有两个因子（1不是素数）
         * 遍历n求出它所有的因子
         */
        while (m != n) {   //当n==m时说明已经不能再除了，跳出循环
            if (m != 0) {
                n = m;
            }
            for (int i = 2; i < Math.sqrt(n) + 1; i++) {
                if (n % i == 0) {
                    m = n / i;    //把商作为下次的被除数
                    list.add(i);    //i就是因子
                    break;
                }
            }
        }
        list.add(m);
        if (list.size() == 2) {
            System.out.println(list.get(0) + " " + list.get(1));
        } else {
            System.out.println("-1 -1");
        }

        /**
         * 示例1
         *
         * 输入
         *
         * 15
         *
         * 输出
         *
         * 3 5
         *
         * 说明
         *
         * 因数分解后，找到两个素数3和5，使得3*5=15，按从小到大排列后，输出3 5
         *
         * 示例2
         *
         * 输入
         *
         * 27
         *
         * 输出
         *
         * -1 -1
         *
         * 说明
         *
         * 通过因数分解，找不到任何素数，使得他们的乘积为27，输出-1 -1
         */
    }
}
