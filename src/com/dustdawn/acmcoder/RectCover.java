package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/4 8:43
 */

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int r1 = 1;
        int r2 = 2;
        int rn = 0;
        for (int i = 3; i <= target; i++) {
            rn = r1 + r2;
            r1 = r2;
            r2 = rn;
        }
        return rn;
    }
}
