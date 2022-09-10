package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 数组二叉树(200分)(递归)
 * 题目描述：
 * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2N和2N+1，
 * 并且我们用值-1代表一个节点为空。
 * 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
 * 输入描述
 * 输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分隔。
 * 注意第一个元素即为根节点的值，即数组的第N个元素对应下标N，下标0在树的表示中没有使用，所以我们省略了。
 * 输入的树最多为7层。
 * 输出描述
 * 输出从根节点到最小叶子节点的路径上，各个节点的值，由空格分隔，用例保证最小叶子节点只有一个。
 *
 * @author dustdawn
 * @date 2022/9/4 11:12
 */
public class S_ArrayBinaryTree {
    public static boolean isLeafNode(int[] nums, int i) {
        return (i * 2 + 1 >= nums.length)
                || (nums[i * 2 + 1] == -1 && i * 2 + 2 >= nums.length)
                || (nums[i * 2 + 1] == -1 && nums[i * 2 + 2] == -1);
    }

    /**
     * 获取i后的叶子节点
     *
     * @param nums
     * @param i
     * @return
     */
    public static int dfs(int[] nums, int i) {
        if (isLeafNode(nums, i)) {
            return i;
        } else {
            // 递归获得左右子树的叶子节点
            int left = dfs(nums, i * 2 + 1);
            int right = dfs(nums, i * 2 + 2);
            if (left >= nums.length || nums[left] == -1) {
                // 只有右节点
                return right;
            } else if (right >= nums.length || nums[right] == -1) {
                // 只有左节点
                return left;
            } else {
                return nums[left] <= nums[right] ? left : right;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        /*int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != -1 && isLeftNode(nums, i)) {
                min = Math.min(min, nums[i]);
            }
        }*/
        List<Integer> list = new ArrayList<>();
        /*for (int i = nums.length - 1; i >= 0; i--) {
            if (min == nums[i]) {
                while (i > 0) {
                    list.add(nums[i]);
                    i = (i - 1) / 2;
                }
                list.add(nums[0]);
                break;
            }
        }*/
        // 方法2
        int i = dfs(nums, 0);
        while (i > 0) {
            list.add(nums[i]);
            i = (i - 1) / 2;
        }
        list.add(nums[0]);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (int item : list) {
            sb.append(item).append(" ");
        }
        System.out.println(sb.toString());
    }
    /**
     * 示例 1：
     * 输入
     * 3 5 7 -1 -1 2 4
     * 输出
     * 3 7 2
     * 说明
     * 最小叶子节点的路径为3 7 2
     * 示例 2：
     * 输入
     * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
     * 输出
     * 5 8 7 6
     * 说明
     * 最小叶子节点的路径为5 8 7 6，注意数组仅存储至最后一个非空节点，故不包含节点“7”右子节点的-1
     * 思路分析：
     * 这道题要计算从根节点到最小的叶子节点的路径，首先二叉树找满足条件的子树，会优先想到dfs，递归找左右子树。
     * 然后就是叶子节点的判断，叶子节点所有父节点的查找。
     * 同时，二叉树是用数组表示的，就可以只按照2N和2N+1来判断左右子树。
     * 叶子节点的判断：
     * return (2 * idx + 1 >= res.size() || res.get(2 * idx + 1) == -1)
     * && (2 * idx + 2 >= res.size() || res.get(2 * idx + 2) == -1);
     * 叶子节点所有父节点的查找：
     * while (idx > 0) {  // 找到最小叶子节点的所有父节点的索引
     * arr.add(res.get(idx));
     * idx = (idx - 1) / 2;
     * }
     */
}
