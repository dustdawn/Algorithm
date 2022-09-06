package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 相对开音节(100分)(字符串分隔+模拟)
 * 相对开音节构成的结构为辅音+元音（aeiou）+辅音(r除外)+e，常见的单词有bike、cake等。
 * 给定一个字符串，以空格为分隔符，反转每个单词中的字母，若单词中包含如数字等其他非字母时不进行反转。
 * 反转后计算其中含有相对开音节结构的子串个数（连续的子串中部分字符可以重复）。
 * 输入描述:
 * 字符串，以空格分割的多个单词，字符串长度<10000，字母只考虑小写
 * 输出描述:
 * 含有相对开音节结构的子串个数，注：个数<10000
 *
 * @author dustdawn
 * @date 2022/9/6 16:55
 */
public class X_Syllable {
    public static String reverseStr(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseStr(s.substring(1)) + s.substring(0, 1);
    }

    public static boolean isKYJ(String str) {
        String yuanyin = "aeiou";
        String s1 = String.valueOf(str.charAt(0));
        String s2 = String.valueOf(str.charAt(1));
        String s3 = String.valueOf(str.charAt(2));
        String s4 = String.valueOf(str.charAt(3));
        if (!yuanyin.contains(s1)    //非元音即辅音
                && yuanyin.contains(s2)
                && !yuanyin.contains(s3) && !s3.equals("r")
                && s4.equals("e")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        int len = s.length;
        int count = 0;

        boolean isAll;  //是否全为英文
        for (int i = 0; i < len; i++) {
            isAll = true;
            String str = s[i];
            int strLen = str.length(); //当前字符串长度
            if (strLen < 4) {    //字符串小于4不符合
                continue;
            }
            for (int j = 0; j < strLen; j++) {
                if (!Character.isLetter(str.charAt(j))) {    //是否有非英文
                    isAll = false;
                }
            }
            if (isAll) {
                str = reverseStr(str);  //全英文则反转
            }
            for (int j = 0; j <= strLen - 4; j++) {
                if (isKYJ(str.substring(j, j + 4))) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    /**
     * 示例1
     *
     * 输入
     *
     * ekam a ekac
     *
     * 输出
     *
     * 2
     *
     * 说明
     *
     * 反转后为 make a cake 其中make、cake为相对开音节子串，返回2
     *
     * 示例2
     *
     * 输入
     *
     * !ekam a ekekac
     *
     * 输出
     *
     * 2
     *
     * 说明
     *
     * 反转后为!ekam a cakeke 因!ekam含非英文字符所以未反转，其中 cake、keke为相对开音节子串，返回2
     */
}
