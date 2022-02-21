package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/3 22:42
 */

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {

    public int JumpFloor(int target) {

        //发现规律
        //1:1
        //2:2
        //3:3
        //4:5
        //5:8
        //满足菲波那切数列
        if (target <= 2) {
            return target;
        }
        int step1 = 1;
        int step2 = 2;
        int step = 0;
        for (int i = 3; i <= target; i++) {
            step = step1 + step2;
            step1 = step2;
            step2 = step;
        }
        return step;

    }
}
