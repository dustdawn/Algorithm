package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 检查是否存在满足条件的数字组合(100分)(暴力公式求和)
 * 给定一个正整数数组，检查数组中是否存在满足规则的数字组合
 * 规则：
 * A = B + 2C
 * 输入描述:
 * 第一行输出数组的元素个数。
 * 接下来一行输出所有数组元素，用空格隔开。
 * 输出描述:
 * 如果存在满足要求的数，在同一行里依次输出规则里A/B/C的取值，用空格隔开。
 * 如果不存在，输出0。
 *
 * @author dustdawn
 * @date 2022/9/9 20:43
 */
public class J_Check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {   //对输入的list遍历 为A
            for (int j = 0; j < n; j++) {   //对输入的list遍历 为B
                if (i == j) {   //下标相同为同一值，跳过
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) { //下标相同为同一值，跳过
                        continue;
                    }
                    if (ints[i] == ints[j] + 2 * ints[k]) {    //进行A=B+2C处理判断
                        list.add(ints[i]);
                        list.add(ints[j]);
                        list.add(ints[k]);
                    }
                }
            }
        }
        if (list.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(list);
        }

        /**
         * 示例1
         *
         * 输入
         *
         * 4
         *
         * 2 7 3 0
         *
         * 输出
         *
         * 7 3 2
         *
         * 说明
         *
         * 7 = 3 + 2 * 2
         *
         * 示例2
         *
         * 输入
         *
         * 3
         *
         * 1 1 1
         *
         * 输出
         *
         * 0
         *
         * 说明
         *
         * 找不到满足条件的组合
         *
         * 备注:
         *
         * 1. 数组长度在3-100之间。
         *
         * 2. 数组成员为0-65535，数组成员可以重复，但每个成员只能在结果算式中使用一次。如：数组成员为[0, 0, 1, 5]，0出现2次是允许的，但结果0 = 0 + 2 * 0是不允许的，因为算式中使用了3个0。
         *
         * 3. 用例保证每组数字里最多只有一组符合要求的解。
         */
    }
}
