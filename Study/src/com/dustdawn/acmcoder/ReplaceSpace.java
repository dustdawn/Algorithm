package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/3 9:37
 */

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int len = str.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            //String s = String.valueOf(str.charAt(i));
            if (c == ' ') { //s.equals(" ");
                sb.append("%20"); //len += 2;
                // str.replace(i, i+1, "%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));
    }
}
