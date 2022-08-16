package com.dustdawn.leetcode.datastructure;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * @author dustdawn
 * @date 2022/5/21 15:46
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        /*
        1.先反转head开头的k个元素
        2.k + 1个元素作为head递归调用reverseKGroup
        3.将两个过程的结果连接起来
         */
        // 将b移至距离head k个位置的节点，即第k + 1个元素
        for (int i = 0; i < k; i++) {
            // 不足k个，不需要反转
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode reverseNode = reverse(a, b);
        // 此时reverseNode反转单组k各元素的头节点，a为尾节点，b为单组反转链表的下一节点
        a.next = reverseKGroup(b, k);
        return reverseNode;
    }

    /**
     * 反转区间[a, b)的元素
     * 通过反转链表迭代解法，反转节点a为头节点的链表其实即为反转节点a到null之间的节点，此处将null替换成b即可
     * @param a
     * @param b
     * @return
     */
    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = b;
        ListNode curr = a;
        while (curr != b) {
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
         * 输入：head = [1,2,3,4,5], k = 2
         * 输出：[2,1,4,3,5]
         * 示例 2：
         *
         *
         *
         * 输入：head = [1,2,3,4,5], k = 3
         * 输出：[3,2,1,4,5]
         */
    }
}
