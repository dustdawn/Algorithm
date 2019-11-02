package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/3 15:07
 */

import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class StackImplQueue {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();


    public static void push(int node) {
        stack1.push(node);
    }
    public static int pop() {
        if(stack2.size() <= 0) {
            while(stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            push(i);
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(pop());
        }


    }
}
