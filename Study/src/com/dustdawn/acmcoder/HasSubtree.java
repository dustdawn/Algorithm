package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/12 8:18
 */

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }

        //从A树中找到与B树根节点相同的结点，根节点->左右结点->左右结点子树

        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean isSubtree(TreeNode pattern, TreeNode target) {
        if (target == null) {//目标树先递归到底，说明目标数为子树
            return true;
        }
        if (pattern == null) {//模板树先递归到底，说明不为子树
            return false;
        }
        if (target.val != pattern.val) {
            return false;
        }

        return isSubtree(pattern.left, target.left) && isSubtree(pattern.right, target.right);
    }
}
