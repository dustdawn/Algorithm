package com.dustdawn.binaryTree;

/**
 * @author dustdawn
 * @date 2019/10/1 10:39
 */

/**
 * 题目描述
 * 对称二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class isSymmetrical {
    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Symmetrical(root.left, root.right);

    }

    public boolean Symmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null && right != null) {
            return false;
        }

        if (left != null && right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;

        }
        return Symmetrical(left.left, right.right);
    }
}
