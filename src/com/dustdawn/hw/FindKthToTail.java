package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 输出单向链表中倒数第k个结点(快慢指针)
 * 题目描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * 链表结点定义如下：
 * struct ListNode
 * {
 * int m_nKey;
 * ListNode* m_pNext;
 * };
 * 正常返回倒数第k个结点指针，异常返回空指针.
 * 要求：
 * (1)正序构建链表;
 * (2)构建后要忘记链表长度。
 * 输入描述：
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 * 输出描述：
 * 输出一个整数
 *
 * @author dustdawn
 * @date 2022/9/4 13:45
 */
public class FindKthToTail {
    /**
     * 示例1
     * 输入：
     * 8
     * 1 2 3 4 5 6 7 8
     * 4
     * 输出：
     * 5
     * 思路分析
     * 主要通过这道题学习一下OJ模式下链表的处理，怎么定义链表生成链表。
     */
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String[] split = sc.nextLine().split(" ");
        ListNode root = null;
        for (int i = split.length - 1; i >= 0; i--) {
            ListNode preNode = new ListNode(Integer.parseInt(split[i]));
            preNode.next = root;
            root = preNode;
        }
        int k = Integer.parseInt(sc.nextLine());
        ListNode left = root;
        ListNode right = root;
        for (int i = 0; i < k - 1; i++) {
            if (right.next == null) {
                System.out.println(0);
                return;
            }
            right = right.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        System.out.println(left.val);
    }
}
