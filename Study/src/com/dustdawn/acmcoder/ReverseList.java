package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/4 14:34
 */

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    //方法一：通过ArrayList的add方法O(n)
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(0, node);
            node = node.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).next = null;
            } else {
                list.get(i).next = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    //方法二：循环逆序
    public static ListNode ReverseListII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head.next != null) {//循环直到链表末结点
            pre = head.next; //保存原下一个节点
            head.next = next;
            next = head;
            head = pre;
        }
        head.next = next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode[] = new ListNode[8];
        for (int i = 0; i < 8; i++) {
            listNode[i] = new ListNode(i + 1);
        }
        for (int i = 0; i < listNode.length - 1; i++) {
            listNode[i].next = listNode[i + 1];
        }

        for (ListNode node : listNode) {
            System.out.print(node.val + " ");
        }

        System.out.println();

        ListNode re = ReverseList(listNode[0]);
        while (re != null) {
            System.out.print(re.val + " ");
            re = re.next;
        }

        System.out.println();

        ListNode re2 = ReverseListII(listNode[7]);
        while (re2 != null) {
            System.out.print(re2.val + " ");
            re2 = re2.next;
        }

    }
}
