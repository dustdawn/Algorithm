package com.dustdawn.binaryTree;

/**
 * @author dustdawn
 * @date 2019/10/1 11:46
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 */
public class BinaryTreeOrder {
    //递归先根遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //递归中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //递归后根遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //非递归先根遍历
    public void preOrders(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode node = null;
        stack.push(root);
        //根左右出，即右左根进
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //非递归中根遍历
    public void inOrders(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        //左根右出，即右根左进
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //无左子树
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            node = cur.right;
        }
    }

    //非递归后根遍历
    public void postOrders(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        s1.push(root);
        TreeNode node = root;
        //左根右出，即右左根进
        while (!s1.isEmpty()) {
            node = s1.pop();
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
            s2.push(node);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
    }

    //非递归后根遍历2
    public void postOrders2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        TreeNode node = root;//保存上一个被遍历的结点
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            //当前结点有左节点，并且左右孩子没有被遍历
            if (cur.left != null && node != cur.left && node != cur.right) {
                stack.push(cur.left);
            } else if (cur.right != null && node != cur.right) {
                //当前结点有右孩子 并且 右孩子没被遍历过
                stack.push(cur.right);
            } else {
                System.out.print(stack.pop().val + " ");
                node = cur;//当前结点遍历过了
            }
        }

    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeOrder order = new BinaryTreeOrder();

        TreeNode[] nodes = new TreeNode[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i + 1);
        }

        for (int i = 0; 2 * i + 2 < nodes.length; i++) {
            nodes[i].left = nodes[2 * i + 1];
            nodes[i].right = nodes[2 * i + 2];
        }

        System.out.println("递归先根遍历序列：");
        order.preOrder(nodes[0]);
        System.out.println("\n递归先根遍历序列：");
        order.inOrder(nodes[0]);
        System.out.println("\n递归先根遍历序列：");
        order.postOrder(nodes[0]);

        System.out.println();

        System.out.println("\n非递归先根遍历序列：");
        order.preOrders(nodes[0]);
        System.out.println("\n非递归中根遍历序列：");
        order.inOrders(nodes[0]);
        System.out.println("\n非递归后根遍历序列：");
        order.postOrders(nodes[0]);
        System.out.println("\n非递归后根遍历序列2：");
        order.postOrders2(nodes[0]);

        System.out.println("\n层序遍历序列：");
        order.levelOrder(nodes[0]);

    }
}
