package com.dustdawn.binaryTree;

/**
 * @author dustdawn
 * @date 2019/9/14 15:36
 */

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;//左右节点都存在则交换,此时注意左右节点的子树也同时交换了
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            Mirror(root.left);//左子树深度遍历直到无左子树
        }
        if (root.right != null) {
            Mirror(root.right);//继续深度遍历其右子树
        }
        //直到为最后一层的叶子节点

    }
}
