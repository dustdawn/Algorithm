package com.dustdawn.leetcode.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 *
 * @author dustdawn
 * @date 2022/4/23 15:51
 */
public class CodecTreeNode {
    private final String SEP = ",";
    private final String NULL = "#";

    /**
     * 把一棵二叉树序列化成字符串
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root, String order) {
        StringBuilder stringBuilder = new StringBuilder();
        if ("pre".equals(order)) {
            serializePre(root, stringBuilder);
        } else if ("post".equals(order)) {
            serializePost(root, stringBuilder);
        }
        return stringBuilder.toString();
    }

    /**
     * 把字符串反序列化成二叉树
     * @param data
     * @param order
     * @return
     */
    public TreeNode deserialize(String data, String order) {
        if (data == null) {
            return null;
        }
        LinkedList<String> nodeList = new LinkedList<>();
        for (String str : data.split(SEP)) {
            nodeList.add(str);
        }
        if ("pre".equals(order)) {
            return deserializePre(nodeList);
        } else if ("post".equals(order)) {
            return deserializePost(nodeList);
        }
        return null;
    }

    /**
     * 先序遍历
     * 辅助函数，将二叉树存入StringBuilder
     *
     * @param root
     * @param stringBuilder
     */
    void serializePre(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append(NULL).append(SEP);
            return;
        }
        /*********** 前序遍历位置 ***********/
        stringBuilder.append(root.val).append(SEP);
        /************************************/
        serializePre(root.left, stringBuilder);
        serializePre(root.right, stringBuilder);
    }

    /**
     * 先序遍历
     * 辅助函数，通过nodeList构造二叉树
     *
     * @param nodeList
     * @return
     */
    TreeNode deserializePre(LinkedList<String> nodeList) {
        if (nodeList.isEmpty()) {
            return null;
        }
        /*********** 前序遍历位置 ***********/
        // 列表最左侧就是根节点
        String first = nodeList.removeFirst();
        if (first == null) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /************************************/
        root.left = deserializePre(nodeList);
        root.right = deserializePre(nodeList);
        return root;
    }

    /**
     * 后序遍历
     * 辅助函数，将二叉树存入StringBuilder
     *
     * @param root
     * @param stringBuilder
     */
    void serializePost(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append(NULL).append(SEP);
            return;
        }
        serializePost(root.left, stringBuilder);
        serializePost(root.right, stringBuilder);
        /*********** 后序遍历位置 ***********/
        stringBuilder.append(root.val).append(SEP);
        /************************************/
    }

    /**
     * 后序遍历
     * 辅助函数，通过nodeList构造二叉树
     *
     * @param nodeList
     * @return
     */
    TreeNode deserializePost(LinkedList<String> nodeList) {
        if (nodeList.isEmpty()) {
            return null;
        }
        /*********** 前序遍历位置 ***********/
        // 列表最左侧就是根节点
        String last = nodeList.removeLast();
        if (last == null) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        /************************************/

        // 先构造右子树，后构造左子树（序列化后的顺序为 左子树-右子树-根节点）
        root.right = deserializePost(nodeList);
        root.left = deserializePost(nodeList);
        return root;
    }

    /**
     * 层级遍历将二叉树序列化成字符串
     *
     * @param root
     * @return
     */
    public String serializeLevel(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 初始化队列，将root加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 出栈
            TreeNode cur = queue.poll();
            /*********** 层级遍历位置 ***********/
            if (cur == null) {
                stringBuilder.append(NULL).append(SEP);
                continue;
            }
            stringBuilder.append(cur.val).append(SEP);
            /************************************/
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return stringBuilder.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(SEP);
        // 第一个元素为根节点的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        for (int i = 1; i < nodes.length; ) {
            // 队列中存的都是父节点
            TreeNode parent = queue.poll();
            // 层级遍历对应父节点个数为1 2 4 8...
            // 父节点对应的左侧节点的值
            String left = nodes[i++];
            if (NULL.equals(left)) {
                parent.left = null;
            } else {
                parent.left = new TreeNode(Integer.parseInt(nodes[i++]));
                queue.offer(parent.left);
            }
            // 父节点对应的右侧节点的值
            String right = nodes[i++];
            if (NULL.equals(right)) {
                parent.right = null;
            } else {
                parent.right = new TreeNode(Integer.parseInt(nodes[i++]));
                queue.offer(parent.right);
            }
        }
        return root;
    }
}
