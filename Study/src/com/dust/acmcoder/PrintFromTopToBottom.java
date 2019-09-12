package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/12 14:55
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    //队列实现层次遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {



        ArrayList list = new ArrayList();
        if (root == null) {
            return list;
        }

        TreeNode node = root;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.val);
        }
        return list;

    }

}
