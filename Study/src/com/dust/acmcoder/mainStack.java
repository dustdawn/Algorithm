package com.dust.acmcoder;

import java.util.Stack;

/**
 * @author dustdawn
 * @date 2019/9/21 15:15
 */

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class mainStack {
    private Stack<Integer> stack = new Stack<>();
    private Integer min = Integer.MAX_VALUE;//栈为空，返回min为最大整型数

    public void push(int node) {
        if (stack.empty()) {//栈为空时将node直接入栈
            min = node;
            stack.push(min);
        }else {
            if (node <= min) {//后续入栈元素如不比最小元素大，则备份旧min，更新min
                stack.push(min);
                min = node;
            }
            //入栈的不可能是最小值直接入栈
            stack.push(node);
        }
    }

    public void pop() {
        if (stack.size() == 0) {
            return;
        }
        if (min == stack.peek()) {//如要弹出的元素为保存的最小值，则弹出该元素,此时栈顶保存的是上一个min的备份，用旧min的值更新min
            if (stack.size() > 1) {
                stack.pop();
                min = stack.peek();
            }else {//如果要弹出是最后一个元素
                min = Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }

    public static void main(String[] args) {
        mainStack o = new mainStack();
        for (int i = 0; i < 8; i++) {
            o.push(i);
        }
        o.push(-1);
        System.out.println(o.min);
        o.pop();
        o.pop();

    }
}
