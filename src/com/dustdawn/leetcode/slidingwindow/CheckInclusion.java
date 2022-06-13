package com.dustdawn.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 提示：
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * @author dustdawn
 * @date 2022/6/13 20:38
 */
public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (need.get(c) == null) {
                need.put(c, 1);
            } else {
                need.put(c, need.get(c) + 1);
            }
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
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
            while (right - left >= s1.length()) {
                // 判断是否找到了合法的排列子串
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
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
        return false;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：s1 = "ab" s2 = "eidbaooo"
         * 输出：true
         * 解释：s2 包含 s1 的排列之一 ("ba").
         * 示例 2：
         *
         * 输入：s1= "ab" s2 = "eidboaoo"
         * 输出：false
         */
    }
}
