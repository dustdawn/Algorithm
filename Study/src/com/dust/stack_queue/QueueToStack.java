package com.dust.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dustdawn
 * @date 2019/10/1 17:11
 */
public class QueueToStack<T> {
    private Queue<T> q1;
    private Queue<T> q2;

    public QueueToStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(T o) {
        q1.offer(o);
    }

    public T pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }


        T o = q1.poll();//最后一个元素
        swap(q1, q2);
        return o;
    }

    public T peek() {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        T o = q1.poll();
        q2.offer(o);
        swap(q1, q2);
        return o;
    }

    private void swap(Queue<T> q1, Queue<T> q2) {
        Queue<T> q = q1;
        q1 = q2;
        q2 = q1;


    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
