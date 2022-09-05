package com.dustdawn.hw;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 数组去重和排序(100分)(排序+哈希表)
 * 题目描述：
 * 给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，
 * 相同出现次数按照第一次出现顺序进行先后排序。
 * 输入描述：
 * 一个数组
 * 输出描述：
 * 去重排序后的数组
 *
 * @author dustdawn
 * @date 2022/9/5 19:07
 */
public class ArraySetSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int[] ints = new int[str.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(str[i]);
        }
        // HashMap<Integer, Integer> map = new HashMap<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < ints.length; i++) {  // 统计数字出现的频次
            map.put(ints[i], map.getOrDefault(ints[i], 0) + 1);
        }
        // Map按value排序，先将map转为list,再排序list
        // List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(entry.getKey() + ",");
            } else {
                System.out.println(entry.getKey());
            }
        }
        /**
         * 示例 1：
         * 输入
         * 1,3,3,3,2,4,4,4,5
         * 输出
         * 3,4,1,2,5
         * 备注
         * 数组大小不超过100 数组元素值大小不超过100
         *
         * 思路分析
         * 又一个哈希表的排序，这个排序相对简单，只需要对value降序排，key读入的顺序，就是第一次出现索引的先后顺序。
         *
         * HashMap的排序，需要先把HashMap转为list，再对list进行排序。
         */
    }
}
