package com.dustdawn.leetcode.datastructure;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author dustdawn
 * @date 2022/5/17 21:31
 */
public class IsValid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == getLeft(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static char getLeft(char ch) {
        if (ch == ')') {
            return '(';
        } else if (ch == ']') {
            return '[';
        } else {
            return '{';
        }
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：s = "()"
         * 输出：true
         * 示例 2：
         *
         * 输入：s = "()[]{}"
         * 输出：true
         * 示例 3：
         *
         * 输入：s = "(]"
         * 输出：false
         * 示例 4：
         *
         * 输入：s = "([)]"
         * 输出：false
         * 示例 5：
         *
         * 输入：s = "{[]}"
         * 输出：true
         */
    }
}
