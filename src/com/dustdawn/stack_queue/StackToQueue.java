package com.dustdawn.stack_queue;

/**
 * @author dustdawn
 * @date 2019/10/1 16:57
 */

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class StackToQueue<T> {

    private Stack<T> s1;
    private Stack<T> s2;

    public StackToQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void offer(T o) {
        s1.push(o);
    }

    public T poll() {
        translate();
        //s2中有直接弹出
        return s2.pop();
    }

    public T peek() {
        translate();
        return s2.peek();
    }

    private void translate() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
