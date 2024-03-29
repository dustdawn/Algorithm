package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/3 15:40
 */

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    //O(n)
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    //二分查找变种O(log n)
    public int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left < right) {
            if (array[left] < array[right]) {
                return array[left];  //第一次判断为没有选择；第n次防止1011情况
            }
            mid = (left + right) / 2;
            if (array[mid] > array[left]) {  //位于高位部分，后移
                left = mid + 1;
            } else if (array[mid] < array[right]) {  //位于低位部分，右边界不变
                right = mid;
            } else {
                left++;   //减小范围
            }
        }
        return array[left];
    }

}
