package com.dustdawn.leetcode.datastructure;

/**
 * 基本的二叉树节点
 * @author dustdawn
 * @date 2022/4/23 14:31
 */
public class TreeNode {
    /**
     * 节点存储的值
     */
    public int val;
    /**
     * 指向左侧子节点的指针
     */
    public TreeNode left;
    /**
     * 指向右侧子节点的指针
     */
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
