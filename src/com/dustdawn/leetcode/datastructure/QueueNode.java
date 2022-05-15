package com.dustdawn.leetcode.datastructure;

/**
 * 树节点队列，用于广度优先遍历树
 *
 * @author dustdawn
 * @date 2022/5/15 10:56
 */
public class QueueNode {
    /**
     * 二叉树结点
     */
    TreeNode node;
    /**
     * 所在位置的深度
     */
    int depth;

    public QueueNode(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
