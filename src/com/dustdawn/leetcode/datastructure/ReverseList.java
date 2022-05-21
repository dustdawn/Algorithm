package com.dustdawn.leetcode.datastructure;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * @author dustdawn
 * @date 2022/5/21 15:50
 */
public class ReverseList {
    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 链表只有一个节点，反转它自己直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = reverseList(head.next);
        /*
        反转后得到的last根据递归出口可知为：链表从head.next到链表尾部反转的头节点，即尾节点
        此时head.next已为上述反转链表中尾节点，将其next指向此时未反转的head节点
         */
        head.next.next = head;
        // 此时的head节点加入反转链表，作为尾节点，其next指向null
        head.next = null;
        // 返回此时反转链表的头节点
        return lastNode;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：head = [1,2,3,4,5]
         * 输出：[5,4,3,2,1]
         * 示例 2：
         *
         *
         * 输入：head = [1,2]
         * 输出：[2,1]
         * 示例 3：
         *
         * 输入：head = []
         * 输出：[]
         */
    }
}
