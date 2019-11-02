package com.dustdawn.binaryTree;

/**
 * @author dustdawn
 * @date 2019/10/1 11:27
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第 K 大节点。
 */
public class kthTallest {
    /*
    思路
        要想找到第 K 大结点必要要知道排序，二叉树的前、中、后遍历中的中序遍历就是从小到大排序。然后遍历的同时计数找到第 K 大节点。
     */
    List<TreeNode> list = new ArrayList<>();
    public TreeNode kthTallest(TreeNode root, int k) {
        inOrder(root);
        int len = list.size();
        if (len >= k) {
            return list.get(len - k);
        }
        return null;

    }
    public void inOrder(TreeNode node) {
        while (node != null) {
            inOrder(node.left);
            list.add(node);
            inOrder(node.right);
        }
    }
}
