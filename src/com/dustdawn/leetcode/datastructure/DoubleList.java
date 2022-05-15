package com.dustdawn.leetcode.datastructure;

/**
 * 双链表类
 *
 * @author dustdawn
 * @date 2022/5/15 16:34
 */
public class DoubleList {
    /**
     * 头虚节点
     */
    private Node head;
    /**
     * 尾虚节点
     */
    private Node tail;
    /**
     * 链表元素数
     */
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 链表尾部添加结点x，时间复杂度为O(1)
     *
     * @param node
     */
    public void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     * 删除链表中的x节点
     *
     * @param node
     */
    public void remove(Node node) {
        if (node == null || node.prev == null || node.next == null) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    /**
     * 删除链表第一个节点，返回该节点
     *
     * @return
     */
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    /**
     * 返回链表长度
     *
     * @return
     */
    public int size() {
        return size;
    }
}
