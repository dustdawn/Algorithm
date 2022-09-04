package com.dustdawn.hw;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 完全二叉树非叶子部分后序遍历(队列数组构建树+dfs递归)
 * 题目描述：
 * 给定一个以顺序储存结构存储整数值的完全二叉树序列（最多1000个整数），请找出此完全二叉树的所有非叶子节点部分，
 * 然后采用后序遍历方式将此部分树（不包含叶子）输出。
 * 1、只有一个节点的树，此节点认定为根节点（非叶子）。
 * 2、此完全二叉树并非满二叉树，可能存在倒数第二层出现叶子或者无右叶子的情况
 * 其他说明：二叉树的后序遍历是基于根来说的，遍历顺序为：左-右-根
 * 输入描述
 * 一个通过空格分割的整数序列字符串
 * 输出描述
 * 非叶子部分树结构
 *
 * @author dustdawn
 * @date 2022/9/4 13:10
 */
public class PostTraversal {
    /**
     * 示例 1：
     * 输入
     * 1 2 3 4 5 6 7
     * 输出
     * 2 3 1
     * 说明
     * 找到非叶子部分树结构，然后采用后序遍历输出
     * 思路分析：
     * 这道题首先考察二叉树的结构，是选择用类去构造二叉树的结构，还是直接使用数组去表示二叉树的结构，
     * 这里两种方法都实现一下。
     * Node类构造数据结构，在用leetcode刷题时，都是构造好的二叉树，只需要直接调用即可，
     * 这里可以通过这道题学习一下自己构造二叉树的结构。
     * 数组实现二叉树，因为这道题是一棵完全二叉树，所以不需要用-1去判断位置是不是空节点，
     * 左右子树的节点分别存储在下标2N和2N+1。
     * 然后就是删除叶子节点，后序遍历，这些都是二叉树的常规算法思路。可以直接使用递归方法去实现。
     */
    static class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static Queue<Node> nodeQueue = new ArrayDeque<>();
    private static Queue<Integer> queue = new ArrayDeque<>();

    public static Node buildTree() {
        Node root = new Node(queue.poll());
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node top = nodeQueue.poll();
            if (!queue.isEmpty()) {
                top.left = new Node(queue.poll());
                nodeQueue.add(top.left);
            } else {
                break;
            }
            if (!queue.isEmpty()) {
                top.right = new Node(queue.poll());
                nodeQueue.add(top.right);
            } else {
                break;
            }
        }
        return root;
    }

    public static Node removeLeaf(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaf(root.left);
        root.right = removeLeaf(root.right);
        return root;
    }

    public static void traverse(Node root, StringBuilder sb) {
        if (root == null || root.left == null || root.right == null) {
            return;
        }
        traverse(root.left, sb);
        traverse(root.right, sb);
        sb.append(root.val).append(" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            queue.add(Integer.parseInt(str[i]));
        }
        Node root = buildTree();
        // root = removeLeaf(root);
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        System.out.println(sb.toString());
    }

}
