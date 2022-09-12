package com.dustdawn.leetcode.queue;

import java.util.*;

/**
 * 151. 反转字符串中的单词(中等)(双端队列)
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 提示：
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 * @author dustdawn
 * @date 2022/9/12 19:20
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        // API方法
        /*
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
        */

        String[] str = s.trim().split(" ");
        int left = 0;
        int right = str.length - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         * 输入：s = "the sky is blue"
         * 输出："blue is sky the"
         * 示例 2：
         * 输入：s = "  hello world  "
         * 输出："world hello"
         * 解释：反转后的字符串中不能存在前导空格和尾随空格。
         * 示例 3：
         * 输入：s = "a good   example"
         * 输出："example good a"
         * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
         */
    }
}
