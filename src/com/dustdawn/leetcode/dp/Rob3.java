package com.dustdawn.leetcode.dp;

import com.dustdawn.leetcode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 提示：
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 *
 * @author dustdawn
 * @date 2022/5/29 13:57
 */
public class Rob3 {
    static Map<TreeNode, Integer> memo = new HashMap<>();

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        /*
        取该节点，然后去下下个节点做选择
        root.left.left和root.left.right和root.right.left和root.right.right不相连，可同时取
         */
        int yes = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob((root.right.right)));
        //不取，然后去下个节点做选择
        int no = rob(root.left) + rob(root.right);
        int res = Math.max(yes, no);
        memo.put(root, res);
        return res;
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         *
         *
         * 输入: root = [3,2,3,null,3,null,1]
         * 输出: 7
         * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
         * 示例 2:
         *
         *
         *
         * 输入: root = [3,4,5,1,3,null,1]
         * 输出: 9
         * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
         */
    }
}
