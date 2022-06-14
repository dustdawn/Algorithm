package com.dustdawn.leetcode.datastructure;

/**
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * 提示：
 * 数中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 107
 * root 是二叉搜索树
 * 1 <= val <= 107
 *
 * @author dustdawn
 * @date 2022/6/14 21:05
 */
public class SearchBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        // 根据二叉搜索树的定义，满足二分搜索思想（有序）
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         *
         *
         * 输入：root = [4,2,7,1,3], val = 2
         * 输出：[2,1,3]
         * Example 2:
         *
         *
         * 输入：root = [4,2,7,1,3], val = 5
         * 输出：[]
         */
    }
}
