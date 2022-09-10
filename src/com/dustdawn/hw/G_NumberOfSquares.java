package com.dustdawn.hw;

import java.util.*;

/**
 * 构成的正方形数量(200分)(数学)
 * 输入N个互不相同的二维整数坐标, 求这N个坐标可以构成的正方形数量。(内积为零的两个向量垂直)
 * 输入描述:
 * 第一行输入为 N，N 代表坐标数量，N为正整数。N <= 100
 * 之后的 K 行输入为坐标 x y以空格分隔，x, y 为整数, -10<=x, y <= 10
 * 输出描述:
 * 输出可以构成的正方形数量
 *
 * @author dustdawn
 * @date 2022/9/10 17:04
 */
public class G_NumberOfSquares {
    public static boolean isZFX(int[] a, int[] b, int[] c, int[] d) {
        List<int[]> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        Map<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                int x = list.get(i)[0] - list.get(j)[0];
                int y = list.get(i)[1] - list.get(j)[1];
                int len = x * x + y * y;    //求四个坐标六个向量的长度
                temp = len;
                map.put(len, map.getOrDefault(len, 0) + 1);
            }
        }
        if (map.size() == 2 && (map.get(temp) == 2 || map.get(temp) == 4)) {    //六条向量有四条相等且另外两条也相等则构成正方形
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] ints = new int[2];
            ints[0] = sc.nextInt();
            ints[1] = sc.nextInt();
            list.add(ints);
        }
        int count = 0;
        int len = list.size();
        if (len > 3) {
            for (int i = 0; i < len - 3; i++) {
                for (int j = i + 1; j < len - 2; j++) {
                    for (int k = j + 1; k < len - 1; k++) {
                        for (int l = k + 1; l < len; l++) {
                            if (isZFX(list.get(i), list.get(j), list.get(k), list.get(l))) {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);

        /**
         * 示例1
         *
         * 输入
         *
         * 3
         *
         * 1 3
         *
         * 2 4
         *
         * 3 1
         *
         * 输出
         *
         * 0
         *
         * 说明
         *
         * 3 个点不足以构成正方形
         *
         * 示例2
         *
         * 输入
         *
         * 4
         *
         * 0 0
         *
         * 1 2
         *
         * 3 1
         *
         * 2 -1
         *
         * 输出
         *
         * 1
         *
         * 说明
         *
         * 此4点可构成正方形
         */
    }
}
