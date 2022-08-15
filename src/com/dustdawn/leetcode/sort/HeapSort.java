package com.dustdawn.leetcode.sort;

/**
 * 堆排序
 * O(n * log2n)
 * 完全二叉树在满足父结点大于左右子数所有节点则为最大堆
 * 完全二叉树下以数组保存后，每个结点序号为0到length-1
 * 完全二叉树每层最多为2^(n-1)个节点
 * 完全二叉树为满二叉树时节点最多为2^(n) - 1，（n为层数）最少有2^(n-1)个节点（n为层数，最后一层为一个节点：2^(n-1) - 1 + 1）
 * 已知结点序号为i，则其父结点为(i-1)/2
 * 同理，其子结点分别为i*2+1,i*2+2
 *
 * @author dustdawn
 * @date 2022/8/15 20:37
 */
public class HeapSort extends Sort {
    public int[] heapSort(int[] array) {
        if (array == null || array.length < 1) {
            return array;
        }
        int len = array.length;
        // 从倒数第二层开始建立最大堆
        buildMaxHeap(array, len);
        // 堆排序后从上至下，从下至上形成最大堆后根节点一定为最大值
        // 循环交换首位和末尾，将换到末尾的最大值移出
        // 循环移出的数作为排序后数组的最后一个元素
        for (int i = len - 1; i >= 0; i--) {
            // 交换最大值和末尾元素
            swap(array, 0, i);
            // 对长度array[0, i]进行堆排序。每次移出最大值后相当于长度i
            heapify(array, i, 0);
        }
        return array;
    }

    /**
     * 构建最大堆
     * 从倒数第二层的最后一个父节点开始倒序做 heapify 操作
     * 即可完成对整个完全二叉树的 heapify
     * 最后子叶序号为len-1,其父结点为(len-1-1)/2
     * @param array
     * @param len
     */
    public void buildMaxHeap(int[] array, int len) {
        for (int i = (len - 2) / 2; i >= 0; i--) {
            heapify(array, len, i);
        }
    }

    /**
     * 对i到len的所有结点及其子结点组成的部分进行 heapify 操作，即形成堆操作
     *
     * @param array
     * @param len
     * @param i
     */
    public void heapify(int[] array, int len, int i) {
        if (i >= len) {
            return;
        }
        int maxIndex = i;
        // 子节点中找出最大值
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        if (i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex]) {
            maxIndex = i * 2 + 2;
        }
        // 最大值发生改变，将最大值和父节点交换位置
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            //对[maxIndex, len]子节点层作递归 heapify 操作
            heapify(array, len, maxIndex);
        }
    }
}
