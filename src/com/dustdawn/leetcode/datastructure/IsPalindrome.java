package com.dustdawn.leetcode.datastructure;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author dustdawn
 * @date 2022/5/21 13:47
 */
public class IsPalindrome {
    static ListNode left;

    public static boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public static boolean traverse(ListNode right) {
        if (right == null) {
            // 到达链表尾端
            return true;
        }
        boolean res = traverse(right.next);
        // 后序遍历代码
        // 如果res为true，此时right到达最右端
        res = res && left.val == right.val;
        left = left.next;
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：head = [1,2,2,1]
         * 输出：true
         * 示例 2：
         *
         *
         * 输入：head = [1,2]
         * 输出：false
         *  
         *
         * 提示：
         *
         * 链表中节点数目在范围[1, 105] 内
         * 0 <= Node.val <= 9
         */
    }
}
