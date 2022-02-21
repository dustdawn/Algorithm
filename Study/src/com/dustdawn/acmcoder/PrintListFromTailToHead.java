package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/3 14:32
 */

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode() {
        this.val = 0;
    }

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListFromTailToHead {
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*if(listNode.next != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }*/
        ListNode node = listNode;
        while (node != null) {
            list.add(0, node.val);
            node = node.next;
        }
        return list;

    }

    public static void main(String[] args) {
        ListNode[] listNode = new ListNode[9];
        for (int i = 0; i < listNode.length; i++) {
            listNode[i] = new ListNode(i + 1);

        }
        for (int i = 0; i < listNode.length - 1; i++) {
            listNode[i].next = listNode[i + 1];
        }

        ArrayList<Integer> arrayList = printListFromTailToHead(listNode[0]);
        System.out.println(arrayList.toString());
    }
}
