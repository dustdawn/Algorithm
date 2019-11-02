package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/4 15:41
 */

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 */
public class Merge {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null || p2 != null) {
            ListNode node = new ListNode();
            if (p1 == null) {
                node.val = p2.val;
                p2 = p2.next;
                temp.next = node;
                temp = node;
                continue;
            }
            if (p2 == null) {
                node.val = p1.val;
                p1 = p1.next;
                temp.next = node;
                temp = node;
                continue;
            }

            if (p1.val < p2.val) {
                node.val = p1.val;
                p1 = p1.next;
            }else if (p1.val >= p2.val){
                node.val = p2.val;
                p2 = p2.next;
            }
            temp.next = node;
            temp = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode[] = new ListNode[3];
        for (int i = 0; i < 3; i++) {
            listNode[i] = new ListNode(2*i+1);
        }
        ListNode listNode1[] = new ListNode[3];

        for (int i = 0; i < 3; i++) {
            listNode1[i] = new ListNode(2*i+2);
        }

        for (int i = 0; i < listNode.length-1; i++) {
            listNode[i].next = listNode[i+1];
            listNode1[i].next = listNode1[i+1];
        }

        for (int i = 0; i < listNode.length; i++) {
            System.out.print(listNode[i].val + " ");
        }
        System.out.println();
        for (int i = 0; i < listNode.length; i++) {
            System.out.print(listNode1[i].val + " ");
        }



        System.out.println();

        ListNode re = Merge(listNode[0],listNode1[0]);
        while (re != null) {
            System.out.print(re.val + " ");
            re = re.next;
        }
    }
}
