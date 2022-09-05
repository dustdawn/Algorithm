package com.dustdawn.hw;

import java.util.*;

/**
 * 查找众数及中位数(100分)(排序+哈希表)
 * 题目描述
 * 1.众数是指一组数据中出现次数量多的那个数，众数可以是多个
 * 2.中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数
 * 3.查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数
 * 输入描述
 * 输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
 * 输出描述
 * 输出众数组成的新数组的中位数
 *
 * @author dustdawn
 * @date 2022/9/5 14:08
 */
public class ModeMedius {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        // hashmap统计出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 按出现次数排序
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        int max = 0;
        // 获取众数列表
        List<Integer> mode = new ArrayList<>();
        for (int key : list) {
            if (map.get(key) >= max) {
                mode.add(key);
                max = map.get(key);
            } else {
                break;
            }
        }
        // 计算中位数
        int medium = 0;
        int length = mode.size();
        if ((length & 1) != 0) {
            medium = mode.get(length / 2);
        } else {
            medium = (mode.get(length / 2 - 1) + mode.get(length / 2)) / 2;
        }
        System.out.println(medium);
        /**
         * 示例1
         * 输入
         * 10 11 21 19 21 17 21 16 21 18 15
         * 输出
         * 21
         * 示例2
         * 输入
         * 2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
         * 输出
         * 3
         * 示例3
         * 输入
         * 5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
         * 输出
         * 7
         * 思路分析
         * 先求众数数组，先统计每个数字出现的次数，统计出现最多次的数字，可以使用hashMap统计并排序。
         * 求众数数组中的中位数
         */
    }
}
