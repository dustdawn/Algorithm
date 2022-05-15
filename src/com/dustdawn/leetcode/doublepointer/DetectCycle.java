package com.dustdawn.leetcode.doublepointer;

import com.dustdawn.leetcode.datastructure.ListNode;

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 *
 * @author dustdawn
 * @date 2022/5/15 16:01
 */
public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /*
            如果相遇，快指针比慢指针多走环的一圈，假设为假设一圈距离为a
            假设相遇点距离环入口第一个节点的距离为x（顺时针），那么起点到入口位置的距离为a - x
            a - x刚好也是相遇点距离第二圈环入口的距离
            此时让其中一指针回到起点，两者同速前进a - x，到会到达环入口
             */
            if (fast == slow) {
                fast = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                // 两个指针相遇的那个节点即为环入口
                return fast;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         *
         * 输入：head = [3,2,0,-4], pos = 1
         * 输出：返回索引为 1 的链表节点
         * 解释：链表中有一个环，其尾部连接到第二个节点。
         * 示例 2：
         *
         *
         *
         * 输入：head = [1,2], pos = 0
         * 输出：返回索引为 0 的链表节点
         * 解释：链表中有一个环，其尾部连接到第一个节点。
         * 示例 3：
         *
         *
         *
         * 输入：head = [1], pos = -1
         * 输出：返回 null
         * 解释：链表中没有环。
         */
    }
}
