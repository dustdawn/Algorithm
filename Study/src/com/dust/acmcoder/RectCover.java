package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/4 8:43
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
