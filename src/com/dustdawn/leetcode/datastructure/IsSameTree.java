package com.dustdawn.leetcode.datastructure;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author dustdawn
 * @date 2022/5/11 19:50
 */
public class IsSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return TreeNodeUtil.isSameTree(p, q);
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：p = [1,2,3], q = [1,2,3]
         * 输出：true
         * 示例 2：
         *
         *
         * 输入：p = [1,2], q = [1,null,2]
         * 输出：false
         * 示例 3：
         *
         *
         * 输入：p = [1,2,1], q = [1,1,2]
         * 输出：false
         *
         */
    }
}
