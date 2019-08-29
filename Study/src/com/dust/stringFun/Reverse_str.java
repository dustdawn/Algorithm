package com.dust.stringFun;

/**
 * @author dustdawn
 * @date 2019/8/1 23:32
 *  字符串反转（N）
 */
public class Reverse_str {
    public static String reverse_str(String str) {
        char[] ch = str.toCharArray();
        char temp;
        for(int i = 0,j = ch.length-1;i<j;i++,j--) {
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
        return new String(ch);

    }
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverse_str(str));
    }

    /**也可采用直接交换法
     * a^a = 0     a^0 = a
     *异或运算
     * a = a^b;
     * b = a^b; //b = a^b = a^b^b = a
     * a = a^b; //a = a^b = a^b^a = b
     *
     * 类似于a = a + b     b = a - b       a = a - b
     */
}
