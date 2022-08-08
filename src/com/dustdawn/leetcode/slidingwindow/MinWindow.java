package com.dustdawn.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 * @author dustdawn
 * @date 2022/8/8 10:38
 */
public class MinWindow {
    public static String minWindow(String s, String t) {
        /*
        在S中使用双指针中的左右指针技巧，先不断增加right扩大窗口，直到窗口中的字符串符合要求
        停止增加right，增加left缩小窗口，直到窗口中的字符串不符合要求
        每增加一次left，都要更新一轮结果
        重复直到right到达字符串S的尽头
         */
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (need.get(c) == null) {
                need.put(c, 1);
            } else {
                need.put(c, need.get(c) + 1);
            }
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引和长度，方便获取最后的结果
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                if (window.get(c) == null) {
                    window.put(c, 1);
                } else {
                    window.put(c, window.get(c) + 1);
                }
                // 每个字符的个数一致
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
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
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：s = "ADOBECODEBANC", t = "ABC"
         * 输出："BANC"
         * 示例 2：
         *
         * 输入：s = "a", t = "a"
         * 输出："a"
         * 示例 3:
         *
         * 输入: s = "a", t = "aa"
         * 输出: ""
         * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
         * 因此没有符合条件的子字符串，返回空字符串。
         */
    }
}
