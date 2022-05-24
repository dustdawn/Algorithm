package com.dustdawn.leetcode.doublepointer;

import com.dustdawn.leetcode.datastructure.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @author dustdawn
 * @date 2022/5/24 21:18
 */
public class DeleteDuplicates {
    /**
     * 同RemoveDuplicates
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：head = [1,1,2]
         * 输出：[1,2]
         * 示例 2：
         *
         *
         * 输入：head = [1,1,2,3,3]
         * 输出：[1,2,3]
         */
    }
}
