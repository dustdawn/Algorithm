package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 最远足迹(字符串提取)
 * 题目描述：
 * 某探险队负责对地下洞穴进行探险。 探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。 探索工作结束后，探险队需要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
 * 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中0<x<1000，0<y<1000。同时存在非法坐标，如(01,1)、(1,01)，(0,100)属于非法坐标。
 * 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为：x * x+ y * y。
 * 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 * 若记录仪中的坐标都不合法，输出总部坐标（0,0）。 备注：不需要考虑双层括号嵌套的情况，比如sfsdfsd((1,2))。
 * 输入描述:
 * 字符串，表示记录仪中的数据。
 * 如：ferga13fdsf3(100,200)f2r3rfasf(300,400)
 * 输出描述：
 * 字符串，表示最远足迹到达的坐标。
 * 如： (300,400)
 *
 * @author dustdawn
 * @date 2022/9/3 17:54
 */
public class MaxDistance {
    /**
     * 示例 1：
     * 输入
     * ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
     * 输出
     * (5,10)
     * 说明
     * 记录仪中的合法坐标有3个： (3,10)， (3,4)， (5,10)，其中(5,10)是相距总部最远的坐标， 输出(5,10)。
     * 示例 2：
     * 输入
     * asfefaweawfaw(0,1)fe
     * 输出
     * (0,0)
     * 说明
     * 记录仪中的坐标都不合法，输出总部坐标(0,0)
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flag) {
                if (ch == ')') {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                    flag = false;
                } else if (ch == '(') {
                    list.remove(list.size() - 1);
                    sb = new StringBuilder();
                } else {
                    sb.append(ch);
                }
            } else {
                if (ch == '(') {
                    flag = true;
                }
            }
        }
        String res = "(0,0)";
        int max = 0;
        for (String s : list) {
            String[] split = s.split(",");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            if (a <= 0 || a >= 1000 || b <=0 || b >= 1000) {
                continue;
            }
            int r = a * a + b * b;
            if (r > max) {
                res = "(" + a + "," + b + ")";
                max = r;
            }
        }
        System.out.println(res);
    }
}
