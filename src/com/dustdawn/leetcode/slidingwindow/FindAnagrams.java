package com.dustdawn.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 *
 * @author dustdawn
 * @date 2022/5/29 17:16
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (need.get(c) == null) {
                need.put(c, 1);
            } else {
                need.put(c, need.get(c) + 1);
            }
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口的更新
            if (need.containsKey(c)) {
                if (window.get(c) == null) {
                    window.put(c, 1);
                } else {
                    window.put(c, window.get(c) + 1);
                }
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= p.length()) {
                // 当窗口符合条件时，把起始索引加入res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入: s = "cbaebabacd", p = "abc"
         * 输出: [0,6]
         * 解释:
         * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
         * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
         *  示例 2:
         *
         * 输入: s = "abab", p = "ab"
         * 输出: [0,1,2]
         * 解释:
         * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
         * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
         * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
         */
    }
}
