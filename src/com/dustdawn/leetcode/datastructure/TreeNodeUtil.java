package com.dustdawn.leetcode.datastructure;

/**
 * 二叉树节点工具类
 *
 * @author dustdawn
 * @date 2022/4/23 14:34
 */
public class TreeNodeUtil {
    /**
     * 二叉树所有节点中的值加plus
     *
     * @param root
     * @param plus
     */
    public static void plusOne(TreeNode root, int plus) {
        if (root == null) {
            return;
        }
        root.val += plus;
        plusOne(root.left, plus);
        plusOne(root.right, plus);
    }

    /**
     * 判断两棵二叉树是否完全相同
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        // 节点均为空，相同
        if (root1 == null && root2 == null) {
            return true;
        }
        // 两者其一为空，不同
        if (root1 == null || root2 == null) {
            return false;
        }
        // 均不为空，值不同则不相同
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    /**
     * 判断是否为二叉搜索树（Binary Search Tree）
     * 定义：一个二叉树中，任意节点的值要大于左子树所有节点的值，且要小于右子树的所有节点的值
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 是否满足条件root大于minNode且root小于maxNode
     *
     * @param root
     * @param minNode
     * @param maxNode
     * @return
     */
    public static boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return true;
        }
        if (minNode != null && root.val <= minNode.val) {
            return false;
        }
        if (maxNode != null && root.val >= maxNode.val) {
            return false;
        }
        // 满足root的左子树均小于root且root的右子树均大于root即为二叉搜索树
        return isValidBST(root.left, minNode, root) && isValidBST(root.right, root, maxNode);
    }

    /**
     * 在BST中查找一个数是否存在
     *
     * @param root
     * @param target
     * @return
     */
    public static boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // 根据二叉搜索树的定义，满足二分搜索思想（有序）
        if (root.val > target) {
            return isInBST(root.left, target);
        } else if (root.val < target) {
            return isInBST(root.right, target);
        } else {
            return true;
        }
    }

    /**
     * 在BST中插入一个数
     *
     * @param root
     * @param val
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            // val小，插到左子树上
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            // val大，插到右子树上
            root.right = insertIntoBST(root.right, val);
        }
        // 已存在时，也直接返回
        return root;
    }

    /**
     * 在BST中删除一个数
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNodeBST(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            // 去左子树寻找key
            root.left = deleteNodeBST(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNodeBST(root.right, key);
        } else {
            // 找到进行删除
            // 没有子节点，直接返回
            /*if (root.left == null && root.right == null) {
                return null;
            }*/
            // 只有一个非空节点，替换即可
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 有两个子节点：1.在左子树找到最大的节点替换；2.在右子树找到最小的节点替换 均可满足BST
            TreeNode minNode = root.right;
            // 选择方案2，找到最小的节点，即最左边的节点
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 此处只修改节点内部值来交换节点
            root.val = minNode.val;
            root.right = deleteNodeBST(root.right, minNode.val);
        }
        return root;
    }

    /**
     * 返回以root为根几点的普通二叉树节点总数
     *
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 返回以root为根节点点的满二叉树节点总数(Perfect Binary Tree：所有叶子节点均在同一层)
     * 节点总数与数的高度呈指数关系
     *
     * @param root
     * @return
     */
    public static int countNodesPBT(TreeNode root) {
        int height = 0;
        // 计算树的高度
        while (root != null) {
            height++;
            root = root.left;
        }
        // 节点总数为2^h - 1;
        return (int) Math.pow(2, height) - 1;
    }

    /**
     * 返回以root为根几点的完全二叉树节点总数(Complete Binary Tree：每一层的节点都紧靠左排列)
     * 结合普通二叉树和满二叉树的求法 O(logN * logN)
     * 一棵完全二叉树的两棵子树，至少有一棵是满二叉树。
     * 所以一定会触发 leftHeight == rightHeight，只消耗O(logN)的复杂度而不会继续递归
     *
     * @param root
     * @return
     */
    public static int countNodesCBT(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;
        // 记录左右子树
        int leftHeight = 0;
        int rightHeight = 0;
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        // 左右子树同高
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }
        // 高度不同，按照普通二叉树的逻辑计算
        return 1 + countNodesCBT(root.left) + countNodesCBT(root.right);
    }

    /**
     * 二叉树的最近公共祖先
     * 输入一棵以root为根的二叉树和二叉树上的两个节点p和q，计算这两个节点的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        情况1：p、q都在以root为根的树中，返回p、q的最近公共祖先
        情况2：p、q都不在以root为根的树中，返回nul
        情况3：p、q只有一个存在以root为根的树中，返回该存在的节点
         */

        // base case
        if (root == null) {
            return null;
        }
        /*
        当p、q其中一个就是root节点
        1.另一个存在以root为根的树中，root即最近公共祖先
        2.另一个不存在以root为根的树中，根据情况3，也返回root
         */
        if (root == p || root == q) {
            return root;
        }
        // 递归左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /*
        假设p为root节点，如q存在以root为根的树，则root为最近公共祖先；如q不存在，则根据情况3也应该返回root
        所以left和right即为 p和q在以root左右子节点为根的树种递归出的最近公共祖先
         */

        // 情况1
        if (left != null && right != null) {
            // left和right非空时，说明p、q分别在以root左右子树中的最近公共祖先都不为空
            // 根据三种情况，p、q只有分别存在root左右子树时才满足（情况1或2为都在同一子树或都不在同一子树），即情况3
            // 而根据情况3，返回的left和right必为p和q，此时root为它们的公共祖先
            // 由于后序遍历(左右根：root.left,root.right之后操作)，root节点左右子树返回的left和right不为空，则root第一个遍历到的根节点，root即为最近公共祖先
            return root;
        }
        // 情况2
        if (left == null && right == null) {
            return null;
        }
        // 情况3
        return left == null ? right : left;
    }
}
