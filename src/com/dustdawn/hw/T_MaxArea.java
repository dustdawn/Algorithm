package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 太阳能板最大面积(100分)(类插入排序)
 * 给航天器一侧加装长方形或正方形的太阳能板（图中的红色斜线区域），需要先安装两个支柱（图中的黑色竖条），再在支柱的中间部分固定太阳能板。
 * 但航天器不同位置的支柱长度不同，太阳能板的安装面积受限于最短一侧的那根支柱长度。如图：
 * 现提供一组整形数组的支柱高度数据，假设每根支柱间距离相等为1个单位长度，计算如何选择两根支柱可以使太阳能板的面积最大
 * 输入描述:
 * 10,9,8,7,6,5,4,3,2,1
 * 注：支柱至少有2根，最多10000根，能支持的高度范围1~10^9的整数。柱子的高度是无序的，例子中递减只是巧合。
 * 输出描述:
 * 可以支持的最大太阳能板面积：（10米高支柱和5米高支柱之间）
 * 25
 *
 * @author dustdawn
 * @date 2022/9/6 15:55
 */
public class T_MaxArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] num = new int[str.length];   //将输入放入整数数组中
        for (int m = 0; m < str.length; m++) {
            num[m] = Integer.parseInt(str[m]);
        }
        int max = 0;    //最大面积
        for (int i = 1; i < num.length; i++) {
            int min = num[i];
            int preIndex;
            for (preIndex = i - 1; preIndex >= 0; preIndex--) {
                min = Math.min(min, num[preIndex]);
                max = Math.max(max, min * (i - preIndex));
            }
        }
        System.out.println(max);
        /**
         * 示例1
         *
         * 输入
         *
         * 10,9,8,7,6,5,4,3,2,1
         *
         * 输出
         *
         * 25
         *
         * 备注:
         *
         * 10米高支柱和5米高支柱之间宽度为5，高度取小的支柱高也是5，面积为25。任取其他两根支柱所能获得的面积都小于25。所以最大的太阳能板面积为25。
         *
         *  解题思路：
         *
         * 1、从第二根支柱开始向后遍历（第一根无法完成挡板）
         *
         * 2、从当前遍历的支柱向前遍历求出第一根支柱至当前支柱的最大面积
         */
    }
}
