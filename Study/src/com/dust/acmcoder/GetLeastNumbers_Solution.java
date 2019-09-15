package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/15 13:34
 */

import java.util.ArrayList;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k <=0 || input.length < k) {
            return arrayList;
        }
        //quickSort(input, 0, input.length-1);
        //insertSort(input);
        //shellSort(input);
        binarySort(input);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;

    }
    //快速排序
    public void quickSort(int[] arr, int left, int right) {
        if (arr.length == 0 || left < 0 || right > arr.length || left > right) {
            return;
        }
        int baseIndex = partition(arr, left, right);
        quickSort(arr, left, baseIndex-1);
        quickSort(arr, baseIndex+1, right);

    }
    public void swap(int[] arr, int i, int j) {
        if (arr.length == 0 || i>arr.length || j>arr.length || i==j) {
            return;
        }
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
    public int partition(int[] arr, int left, int right) {
        if (arr.length == 0 || left < 0 || right > arr.length || left > right) {
            return -1;
        }
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= base) {
                --right;
            }
            swap(arr, left, right);
            while (left < right && arr[left] <= base) {
                ++left;
            }
            swap(arr, right, left);
        }
        arr[left] = base;
        return left;
    }
    //插入排序O(n^2)
    public void insertSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i-1;
            current = arr[i];
            while (preIndex >=0 && current < arr[preIndex]) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
    }
    //希尔排序
    public void shellSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int tap = arr.length/2;
        int current, preIndex;
        while (tap > 0) {
            for (int i = tap; i < arr.length; i++) {
                preIndex = i - tap;
                current = arr[i];
                while (preIndex >= 0 && current < arr[preIndex]) {
                    arr[preIndex+tap] = arr[preIndex];
                    preIndex -= tap;
                }
                arr[preIndex+tap] = current;
            }
            tap /= 2;
        }

    }
    //二分插入排序O(nlogn)
    public void binarySort(int arr[]) {
        if (arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int left = 0;
            int right = i-1;//将当前元素前的已排好序元素二分查询
            int mid;
            int temp = arr[i];
            while (left <= right) {  //等于保证left所在位置数一定大于插入元素,right小于
                mid = (left + right)/2;
                if (temp > arr[mid]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }


            for (int j = i-1; j >= left; j--) {//大于当前插入元素后移
                arr[j+1] = arr[j];
            }
            arr[left] = temp;//后移后arr[i]发生改变，所以需要用临时变量保存
        }

    }

    public static void main(String[] args) {
        System.out.println(new GetLeastNumbers_Solution().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4));
    }
}
