package com.dust.stringFun;

import com.dust.utils.Utils;

import java.util.Arrays;

/**
 * @author dustdawn
 * @date 2019/10/14 15:16
 *
 * 求多个整数组合成的最大数
 */
public class MaxNumber {
    public boolean compare(int a, int b) {
        int digit1 = 1, digit2 = 1;
        int tempA = a;
        int tempB = b;
        while (a > 0) {
            digit1 *= 10;
            a /= 10;
        }
        while (b > 0) {
            digit2 *= 10;
            b /= 10;
        }
        return (tempA * digit2 + tempB) < (tempB * digit1 + tempA);
    }
    public boolean compareII(int a, int b) {
        int maxI = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int maxJ = Integer.parseInt(String.valueOf(b) + String.valueOf(a));
        return maxI < maxJ;
    }
    public void maxNumber(int[] arr) {
        boolean isChanged = true;
        for (int i = 1; i < arr.length && isChanged; i++) {
            isChanged = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (compareII(arr[j], arr[j+1])) {
                    Utils.swap(arr, j, j+1);
                    isChanged = true;
                }
            }
        }
        System.out.println(Arrays.toString(arr).replace("[", "")
                                                .replace("]","")
                                                .replace(",", "")
                                                .replace(" ",""));
    }


    public static void main(String[] args) {
        new MaxNumber().maxNumber(new int[]{45, 67, 98, 29, 291});
    }
}
