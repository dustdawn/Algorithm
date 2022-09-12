package com.dustdawn.leetcode.ability;

/**
 * 阿拉伯数字转中文数字
 *
 * @author dustdawn
 * @date 2022/9/12 20:23
 */
public class IntToChineseNum {
    public static String IntToChineseNum(int src) {
        final String num[] = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        final String unit[] = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        String dst = "";
        int count = 0;
        while (src > 0) {
            dst = (num[src % 10] + unit[count]) + dst;
            src = src / 10;
            count++;
        }
        return dst.replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "");
    }

    public static void main(String[] args) {
        System.out.println(IntToChineseNum(103004032));
    }
}
