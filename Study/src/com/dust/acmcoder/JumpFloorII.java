package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/4 8:23
 */

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    /**
     * 分析：所有情况的和可以分解为
     * 第一次跳0个台阶，剩余n个台阶的跳法+
     * 第一次跳1个台阶，剩余n-1个台阶的跳法+
     * 第一次跳2个台阶，剩余n-2个台阶的跳法+...+
     * 第一次跳n-1个台阶，剩余1个台阶的跳法
     * 所以可以使用递归解决，出口为1个台阶只有一种跳法，2个台阶有两种跳法。
     */
    public static int JumpFloorII(int target) {

        if (target < 1) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }

        int count = 1;
        while (target > 1) {
            count += JumpFloorII(target - 1);
            target--;
        }
        return count;
    }
}
