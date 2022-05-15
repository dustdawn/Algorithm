package com.dustdawn.leetcode.dfs;

import com.dustdawn.leetcode.datastructure.TreeNode;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author dustdawn
 * @date 2022/5/11 20:23
 */
public class MinDepth {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null || root.right == null) {
            // 有一个子节点，说明不为叶子结点，继续往下递归
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            // 有两个子节点，判断左右子树的最小深度
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：root = [3,9,20,null,null,15,7]
         * 输出：2
         * 示例 2：
         *
         * 输入：root = [2,null,3,null,4,null,5,null,6]
         * 输出：5
         */
    }
}
