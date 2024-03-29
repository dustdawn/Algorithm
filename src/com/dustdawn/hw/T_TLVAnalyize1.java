package com.dustdawn.hw;

import java.util.Scanner;

/**
 * TLV解析Ⅰ(100分)(进制转换)
 * 题目描述：
 * TLV 编码是按 [ Tag Length Value ] 格式进行编码的，一段码流中的信元用Tag标识， Tag在码流中 唯一不重复 ，
 * Length表示信元Value的长度，Value表示信元的值。
 * 码流以某信元的Tag开头，Tag固定占 一个字节，Length固定占 两个字节，字节序为 小端序 。
 * 现给定TLV格式编码的码流，以及需要解码的信元Tag，请输出该信元的Value。
 * 输入码流的16进制字符中，不包括小写字母，且要求输出的16进制字符串中也不要包含小写字母；
 * 码流字符串的最大长度不超过50000个字节。
 * 输入描述：
 * 输入的第一行为一个字符串，表示待解码信元的 Tag ；
 * 输入的第二行为一个字符串，表示待解码的 16进制码流 ，字节之间用 空格分隔 。
 * 输出描述:
 * 输出一个字符串，表示待解码信元以16进制表示的 Value
 * 说明
 * 需要解析的信元的Tag是31，从码流的起始处开始匹配，
 * Tag为32的信元长度为1（01 00，小端序表示为1）；
 * 第二个信元的Tag是90，其长度为2；
 * 第三个信元的Tag是30，其长度为3；
 * 第四个信元的Tag是31，其长度为2（02 00），所以返回长度后面的两个字节即可，即32 33。
 *
 * @author dustdawn
 * @date 2022/9/3 15:10
 */
public class T_TLVAnalyize1 {
    public static void main(String[] args) {
        // 思路分析
        // 字符串转整数时，可以直接转为对应进制的整数。注意是小端，小的在后面。
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length - 2; ) {
            int length = Integer.parseInt(str[i + 2] + str[i + 1], 16);
            if (str[i].equals(n)) {
                for (int j = i + 3; j < i + 3 + length; j++) {
                    sb.append(str[j]).append(" ");
                }
                System.out.println(sb.toString());
                break;
            } else {
                i += length + 3;
            }
        }
        /**
         * 示例 1 ：
         *
         * 输入
         * 31
         * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
         * 输出
         * 32 33
         */
    }
}
