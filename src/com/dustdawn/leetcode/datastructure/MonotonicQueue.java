package com.dustdawn.leetcode.datastructure;

import java.util.LinkedList;

/**
 * 单调队列MonotonicQueue
 * 加入队列中的元素值从左到右单调递减
 * @author dustdawn
 * @date 2022/5/21 15:24
 */
public class MonotonicQueue {
    LinkedList<Integer> queue = new LinkedList<>();

    public void push(int n) {
        while (!queue.isEmpty() && queue.getLast() < n) {
            queue.pollLast();
        }
        queue.addLast(n);
    }

    public int max() {
        return queue.getFirst();
    }

    public void pop(int n) {
        if (n == queue.getFirst()) {
            queue.pollFirst();
        }
    }
}
