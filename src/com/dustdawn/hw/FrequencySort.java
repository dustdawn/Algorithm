package com.dustdawn.hw;

import java.util.*;

/**
 * 根据字符出现频率排序(排序+哈希表)
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * 提示:
 * 1 <= s.length <= 5 * 105
 * s 由大小写英文字母和数字组成
 *
 * @author dustdawn
 * @date 2022/9/5 12:17
 */
public class FrequencySort {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i);
            int fre = map.get(ch);
            for (int j = 0; j < fre; j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: s = "tree"
         * 输出: "eert"
         * 解释: 'e'出现两次，'r'和't'都只出现一次。
         * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
         * 示例 2:
         *
         * 输入: s = "cccaaa"
         * 输出: "cccaaa"
         * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
         * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
         * 示例 3:
         *
         * 输入: s = "Aabb"
         * 输出: "bbAa"
         * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
         * 注意'A'和'a'被认为是两种不同的字符。
         */
    }
}
