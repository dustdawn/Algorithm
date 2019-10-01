package com.dust.binaryTree;

/**
 * @author dustdawn
 * @date 2019/9/24 10:37
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;//指向父结点的指针
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
        next = null;
    }
    TreeNode() {
        val = 0;
        left = null;
        right = null;
        next = null;
    }

}
