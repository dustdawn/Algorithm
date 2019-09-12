package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/12 15:59
 */

import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 *
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length || pushA.length == 0) {
            return false;
        }
        //将压入序列入栈，直到出现与弹栈元素相同的出栈
        Stack<Integer> stack = new Stack();
        for (int i = 0, j = 0; i < pushA.length && j < pushA.length;++i) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                ++j;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{5,4,3,2,1}));
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{3,5,4,2,1}));
    }
}
