package com.dustdawn.hw;

import java.util.Scanner;
import java.util.Stack;

/**
 * 字符串消除(100分)(暴力/栈)
 * 题目描述：
 * 游戏规则： 输入一个只包含英文字母的字符串, 字符串中的两个字母如果相邻且相同,就可以消除。
 * 在字符串上反复执行消除的动作, 直到无法继续消除为止,此时游戏结束。 输出最终得到的字符串长度.
 * 输入描述:
 * 输入原始字符串str 只能包含大小写英文字母,字母的大小写敏感, str长度不超过100
 * 输出描述：
 * 输出游戏结束后,最终得到的字符串长度
 *
 * @author dustdawn
 * @date 2022/9/3 21:17
 */
public class Z_RemoveString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean flag = true;
        while (flag) {
            flag = false;
            char[] chs = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chs.length; ) {
                if (!Character.isLetter(chs[i])) {
                    System.out.println(0);
                    return;
                }
                int j = i + 1;
                if (j < chs.length && chs[i] == chs[j]) {
                    i += 2;
                    flag = true;
                } else {
                    sb.append(chs[i++]);
                }
            }
            str = sb.toString();
        }
        System.out.println(str.length());

        // 栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isLetter(ch)) {
                System.out.println(0);
                return;
            }
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        System.out.println(stack.size());

        /**
         * 示例 1：
         * 输入
         * gg
         * 输出
         * 0
         * 说明
         * gg可以直接消除 得到空串 长度为0
         * 示例 2：
         * 输入
         * mMbccbc
         * 输出
         * 3
         * 说明
         * mMbccbc中 可以先消除cc 此时变为mMbbc 再消除 bb 此时变成mMc 此时没有相同且相邻的字符
         * 无法继续消除 最终得到字符串mMc 长度为3
         * 备注：
         * 输入中包含非大小写英文字母时 均为异常输入 直接返回0
         */
    }
}
