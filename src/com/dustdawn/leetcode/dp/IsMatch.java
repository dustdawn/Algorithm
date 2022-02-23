package com.dustdawn.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * @author dustdawn
 * @date 2022/2/23 20:57
 */
public class IsMatch {
    private static Map<String, Boolean> memo = new HashMap<>();

    public static boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    /**
     * 2.dp函数含义：dp(s, i, p, j) = true表示s[i..]可以匹配p[j++]，反正无法匹配
     *
     * @param s 字符串
     * @param i 开始索引
     * @param p 字符规律
     * @param j 开始索引
     * @return
     */
    public static boolean dp(String s, int i, String p, int j) {
        // 备忘录，消除重叠子问题，记录状态(i, j)
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        /**
         * 1.base case
         */
        if (j == p.length()) {
            // 字符串和规则串完全匹配结束即匹配成功
            return i == s.length();
        }
        if (i == s.length()) {
            // 规则串单独未匹配完毕时，如剩下规则串能匹配空串则匹配成功
            // 规则串能匹配空串，说明剩下部分为x*y*格式，为偶数（a ab*c*）
            if ((p.length() - j) % 2 != 0) {
                // 为奇数则一定匹配失败
                return false;
            }
            for (; j < p.length(); j = j + 2) {
                // 为偶数，所以p.charAt(j + 1)一定存在
                if (p.charAt(j + 1) != '*') {
                    // 不满足b*c*条件
                    return false;
                }
            }
            // 满足条件，匹配成功
            return true;
        }
        /**
         * 3.状态转移方程
         */
        boolean res = false;
        // 规则串下一位是否为*号
        boolean ifStar = j < p.length() - 1 && p.charAt(j + 1) == '*';
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 字符匹配上
            if (ifStar) {
                // 下一位为*，可匹配0次或多次（aa a*bb）
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                // 不为*单独字符匹配，s和p均后移
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (ifStar) {
                // 下一位为*，只能匹配0次（aa b*aa）
                res = dp(s, i, p, j + 2);
            } else {
                // 不为*单独字符匹配，无法继续匹配
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a", "b*a*"));
    }
}
