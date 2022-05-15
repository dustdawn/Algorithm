package com.dustdawn.leetcode.bfs;

import com.dustdawn.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * @author dustdawn
 * @date 2022/5/11 20:23
 */
public class MinDepth {
    /**
     * 广度优先搜索(Broad First Search)
     * 时间复杂度：O(N)O(N)，其中 NN 是树的节点数。对每个节点访问一次。
     * 空间复杂度：O(N)O(N)，其中 NN 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 记录扩散的步数，root本身为一层，初始化为1
        int depth = 1;
        while (!queue.isEmpty()) {
            // 扩散的次数
            int size = queue.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 遍历到叶子节点
                if (node.left == null && node.right == null) {
                    return depth;
                }
                // node的相邻结点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 子节点无叶子节点，继续BFS，更新扩散步数
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         *
         * 输入：root = [3,9,20,null,null,15,7]
         * 输出：2
         * 示例 2：
         *
         * 输入：root = [2,null,3,null,4,null,5,null,6]
         * 输出：5
         */
    }
}
