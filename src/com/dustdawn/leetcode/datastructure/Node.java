package com.dustdawn.leetcode.datastructure;

/**
 * 双链表节点类
 *
 * @author dustdawn
 * @date 2022/5/15 16:35
 */
public class Node {
    /**
     * 节点存储的键
     */
    public int key;
    /**
     * 节点存储的值
     */
    public int val;
    /**
     * 下一邻结节点
     */
    public Node next;
    /**
     * 上一邻结节点
     */
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
