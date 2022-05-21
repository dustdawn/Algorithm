package com.dustdawn.leetcode.datastructure;

import java.util.List;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * @author dustdawn
 * @date 2022/5/21 16:14
 */
public class ReverseBetween {
    static ListNode successor = null;

    /**
     * 递归
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left == 1) {
            // 相当于反转前n个元素
            return reverseN(head, right);
        }
        /*
        对于head.next来说就是反转区间[left -1, right - 1]
        前进到反转点，触发base case
        reverseBetween返回的结果即为反转链表的头节点，其尾节点已指向right + 1号节点，此时只需要把head节点指向返回的头节点即可
         */
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public static ListNode reverseN(ListNode head, int n) {
        // 记录第n + 1个节点，反转整个链表，反转后的链表尾节点指向null，反转前n个节点，尾节点指向n + 1号节点
        if (n == 1) {
            successor = head.next;
            return head;
        }
        // 以head.next为起点，需要反转n - 1个节点
        ListNode lastNode = reverseN(head.next, n - 1);
        // 同反转链表
        head.next.next = head;
        // 反转后的head节点指向未反转部分的第一个节点
        head.next = successor;
        return lastNode;
    }

    /**
     * 迭代
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置虚节点来找到left的前一个节点
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode next = null;
        ListNode curr = prev.next;
        // 迭代交换如[1,2,3,4,5]反转2,4，第一次将2和3交换
        for (int i = 0; i < right - left; i++) {
            /*
            第一次prev为1
            第一次curr为2
            第一次next为3
             */
            next = curr.next;
            // 第一次2指向4
            curr.next = next.next;
            // 第一次3指向2
            next.next = prev.next;
            // 第一次1指向3
            prev.next = next;
            /*
            完成对2,3的反转，此时
            prev为1-3-2-4-5
            curr为2-4-5
            next为3-2-4-5
             */
            /*
            每次将curr.next移到prev.next的位置
                    初始          第一次循环       第二次循环
            prev    1-2-3-4-5     1-3-2-4-5        1-4-3-2-5
            curr    2-3-4-5       2-4-5            2-5
            next    null          3-2-4-5          4-3-2-5
             */

        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：head = [1,2,3,4,5], left = 2, right = 4
         * 输出：[1,4,3,2,5]
         * 示例 2：
         *
         * 输入：head = [5], left = 1, right = 1
         * 输出：[5]
         */
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr[0], null);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i], null);
            curr.next = node;
            curr = node;
        }
        // ListNode node = reverseBetween(head, 2, 4);
        ListNode node = reverseBetween2(head, 2, 4);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
