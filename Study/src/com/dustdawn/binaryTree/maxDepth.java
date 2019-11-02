package com.dustdawn.binaryTree;

/**
 * @author dustdawn
 * @date 2019/10/1 11:37
 */

/**
 * 题目描述
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶子节点依次经过的节点（包含根、叶子节点）形成树的一条路径，最长路径的长度树的深度。
 */
public class maxDepth {
    //递归获取
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ldepth = getMaxDepth(root.left);
        int rdepth = getMaxDepth(root.right);

        return Math.max(ldepth, rdepth) + 1;
    }
}
