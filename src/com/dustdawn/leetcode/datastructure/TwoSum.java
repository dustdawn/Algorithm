package com.dustdawn.leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 170. 两数之和 III - 数据结构设计
 * 设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
 * add 操作 - 对内部数据结构增加一个数。
 * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
 *
 * @author dustdawn
 * @date 2022/5/15 18:25
 */
public class TwoSum {
    Map<Integer, Integer> freq = new HashMap<>();

    public void add(int number) {
        // 记录 number 出现的次数
        if (!freq.containsKey(number)) {
            freq.put(number, 1);
        } else {
            freq.put(number, freq.get(number) + 1);
        }
    }

    public boolean find(int value) {
        for (Integer key : freq.keySet()) {
            int other = value - key;
            if (other == key && freq.get(key) > 1) {
                return true;
            }
            if (other != key && freq.containsKey(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         * add(1); add(3); add(5);
         * find(4) -> true
         * find(7) -> false
         *
         * 示例 2:
         * add(3); add(1); add(2);
         * find(3) -> true
         * find(6) -> false
         */
    }
}
