package com.dustdawn.binaryTree;

/**
 * @author dustdawn
 * @date 2019/10/1 10:18
 */

/**
 * 题目描述
 * 请找出二叉树中序遍历顺序的下一个结点并且返回
 */
public class getNextNode {
    /*
    思路：
        1.有右子结点（当前结点下一结点很有可能是右子结点）
            右子结点有无左子结点（中序 左根右）
                无 - 右子结点就是当前结点的下一结点
                有 - 递归查找右子结点的左子结点
        2.无右子结点（无右结点，下一结点往上找）
            有无父结点
                无 - 无下一结点
                有 - 当前结点为父结点的左子结点，父结点即为下一结点
                     当前结点为父结点的右子结点，父结点递归寻找其父结点
     */
    public TreeNode getNextNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.right != null) {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        } else {
            while (root.next != null) {
                TreeNode froot = root.next;
                if (froot.left == root) {
                    return froot;
                }
                root = root.next;
            }
            return null;
        }
    }
}
