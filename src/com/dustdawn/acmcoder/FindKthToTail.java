package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/4 13:59
 */

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

public class FindKthToTail {
    //思路：前结点快k-1步，当前结点走到末结点，当前结点即为目标结点
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (k == 0 || head == null) {
            return null;
        }
        ListNode target = head;
        ListNode pre = head;
        for (int i = 1; i < k; ++i) {//前结点步差k-1
            if (pre.next == null) {
                return null;
            }
            pre = pre.next;
        }

        while (pre.next != null) {
            pre = pre.next;
            target = target.next;
        }
        return target;
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
        System.out.println(FindKthToTail(listNode[0], 1).val);
    }
}
