package com.dustdawn.leetcode.Ability;

/**
 * 1523. 在区间范围内统计奇数数目
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 *
 * @author dustdawn
 * @date 2022/2/26 15:38
 */
public class CountOdds {
    public static int countOdds(int low, int high) {
        // low是否为奇数
        boolean lowFlag = low % 2 == 1;
        // high是否为奇数
        boolean highFlag = high % 2 == 1;
        // 规则串
        int temp = (high - low) / 2;
        if (lowFlag && highFlag) {
            // 两者同为奇数
            if (low == high) {
                // 两者相等，只有一奇数本身
                return 1;
            }
            // 两者相隔位数，奇数之间为偶数，即一个位数中间有0个奇数，两个位数有1个奇数
            if (temp == 1) {
                // 奇数个数只有low和high
                return 2;
            } else {
                // > 1时，奇数个数为(temp - 1) + 2（2为low和high两个奇数）
                return temp + 1;
            }
        } else if (!lowFlag && !highFlag) {
            // 两者同为偶数
            if (low == high) {
                // 两者相等，无奇数
                return 0;
            }
            // 两者相隔位数，偶数之间为奇数，即一个位数中间有1个奇数，两个位数有2个奇数
            if (temp == 1) {
                return 1;
            } else {
                // > 1时，奇数个数为temp个
                return temp;
            }
        } else {
            // 两者为一奇数一偶数
            // 规律为：中间奇数个数(high-low) / 2 + 1（其中的一个奇数，两者必不相等）
            return temp + 1;
        }
    }

    public static int countOdds2(int low, int high) {
        // high到low的长度
        int length = high - low + 1;
        if (low % 2 == 1 && length % 2 == 1) {
            // low和length均为奇数时，奇数个数为length / 2 + 1（low）
            return length / 2 + 1;
        } else {
            return length / 2;
        }
    }

    public static void main(String[] args) {
        /**
         * 输入：low = 3, high = 7
         * 输出：3
         * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
         */
        System.out.println(countOdds(3, 7));
        System.out.println(countOdds(14, 17));
    }
}
