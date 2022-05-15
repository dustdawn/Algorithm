package com.dustdawn.leetcode.datastructure;

/**
 * 单链表节点类型
 * @author dustdawn
 * @date 2022/5/15 15:12
 */
public class ListNode {
    /**
     * 节点存储的值
     */
    public int val;
    /**
     * 指向下一个节点的指针
     */
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
