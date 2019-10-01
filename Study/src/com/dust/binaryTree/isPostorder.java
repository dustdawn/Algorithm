package com.dust.binaryTree;

import java.util.Arrays;

/**
 * @author dustdawn
 * @date 2019/10/1 11:02
 */

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历。如果是返回 true，如果不是返回 false。假设输入的任意两个数字互不相同。
 */
public class isPostorder {

    /*
    思路
        根据后续遍历的规律和二叉树具备的特点，可以找到的规律就是（左、右、根）序列的最后一个数为根节点，
        又根据二叉树的特点，左子节点小于根节点，右子节点大于根节点，分离出左右子节点，根据上边的规律，递归剩下的序列。
     */
    public boolean isPostorder(int[] arr) {
        if (arr.length == 0) {
            return true;
        }

        int rootVal = arr[arr.length-1];
        int i = 0;
        // 搜索小于根节点的值,并记录该结点的下标(除根节点外)
        for (; i < arr.length-1; i++) {
            if (arr[i] > rootVal) {
                break;
            }
        }

        // 搜索大于根节点的值（除根节点外）

        for (int j = i; j < arr.length-1; j++) {
            if (rootVal > arr[j]) {
                return false;
            }
        }
        // 递归判断左子节点的值（先判断左子节点是够有值），默认返回 true
        boolean left = true;
        if (i > 0) {
            left = isPostorder(Arrays.copyOfRange(arr, 0, i));
        }

        // 如果右子树不为空，判断右子树为二叉搜索树
        boolean right = true;
        if (i < arr.length - 1) {
            right = isPostorder(Arrays.copyOfRange(arr, i ,arr.length-1));
        }


        return left && right;
    }
}
