package com.dustdawn.hw;

import java.util.*;

/**
 * 身高体重排序(100分)(排序+哈希表)
 * 题目描述：
 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
 * 输入描述：
 * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。。
 * 输出描述：
 * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始，身高从低到高，身高相同体重从轻到重，体重相同维持原来顺序。
 *
 * @author dustdawn
 * @date 2022/9/5 16:59
 */
public class HeightWeightSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] height = in.nextLine().split(" ");
        String[] weight = in.nextLine().split(" ");
        int[] h = new int[n];
        int[] w = new int[n];
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(height[i]);
            w[i] = Integer.parseInt(weight[i]);
            map.put(i, new int[]{0, 0});
            int[] info = map.get(i);
            info[0] = h[i];
            info[1] = w[i];
        }

        // Map按value排序，先将map转为list,再排序list(按value值进行排序)
        List<Map.Entry<Integer, int[]>> list = new ArrayList<Map.Entry<Integer, int[]>>(map.entrySet());
        // 通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, int[]>>() {
            @Override
            public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                // 降序排序
                int re = o1.getValue()[0] - o2.getValue()[0];
                if (re != 0) {
                    return re;
                }
                re = o1.getValue()[1] - o2.getValue()[1];
                if (re != 0) {
                    return re;
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, int[]> mapping : list) {
            sb.append(mapping.getKey() + 1 + " ");
        }
        System.out.print(sb.toString().trim());
        /**
         * 示例 1：
         * 输入
         * 4
         * 100 100 120 130
         * 40 30 60 50
         * 输出
         * 2 1 3 4
         * 示例 2：
         * 输入
         * 3
         * 90 110 90
         * 45 60 45
         * 输出
         * 1 3 2
         */
    }
}
