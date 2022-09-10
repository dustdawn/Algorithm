package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 拼接URL(100分)(字符串替换)
 * 题目描述：
 * 给定一个url前缀和url后缀,通过,分割 需要将其连接为一个完整的url
 * 如果前缀结尾和后缀开头都没有/，需要自动补上/连接符
 * 如果前缀结尾和后缀开头都为/，需要自动去重
 * 约束：不用考虑前后缀URL不合法情况
 * 输入描述:
 * url前缀(一个长度小于100的字符串) url后缀(一个长度小于100的字符串)
 * 输出描述：
 * 拼接后的url
 *
 * @author dustdawn
 * @date 2022/9/3 17:18
 */
public class P_URLPre {
    /**
     * 示例 1：
     * 输入
     * /acm,/bb
     * 输出
     * /acm/bb
     * 示例 2：
     * 输入
     * /abc/,/bcd
     * 输出
     * /abc/bcd
     * 示例 3：
     * 输入
     * /acd,bef
     * 输出
     * /acd/bef
     * 示例 4：
     * 输入
     * ,
     * 输出
     * /
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] url = str.split(",");
        if (url.length == 0) {
            System.out.println("/");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/").append(url[0]).append("/").append(url[1]);
        System.out.println(sb.toString().replaceAll("/+", "/"));
    }
}
