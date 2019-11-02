package com.dustdawn.mianshi;

import java.util.Arrays;

public class Solution_9 {

	
	public static void main(String[] args) {
		int array[] = {66,13,51,76,81,26,57,69,23};
		System.out.println("排序前"+Arrays.toString(array));
		heapSort(array);
		System.out.println("排序后"+Arrays.toString(array));
	} 
	public static void heapSort(int[] arr) {
		if(arr!=null&&arr.length!=0) {
			int len = arr.length;
			int k = 1;
			buildMaxHeap(arr,len);
			for(int i = len-1;i>=0;i--){
				//交换最大值和末尾元素
				swap(arr,0,i);
				//每次移出最大值后相当于长度n=i
				heapify(arr,i,0);
				out("堆排序：",k++,Arrays.toString(arr));
			}
		}

	}
	public static void buildMaxHeap(int[] arr,int len) {
		for(int i = (len-2)/2;i>=0;i--)
			heapify(arr,len,i);
	}
	public static void heapify(int[] arr,int len,int i) {
		if(i>=len)
			return;
		int maxIndex = i;
		if(i*2+1<len && arr[i*2+1]>arr[maxIndex])
			maxIndex = i*2+1;
		if(i*2+2<len && arr[i*2+2]>arr[maxIndex])
			maxIndex = i*2+2;
		if(maxIndex != i) {
			swap(arr,maxIndex,i);
			//对子层作递归heapify操作
			heapify(arr,len,maxIndex);
		}
	}
	
	//交换数组元素
	public static void swap(int array[],int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
		
		
	public static void out(String s,int n,String arr) {
		System.out.println(s+"第"+n+"趟"+arr);
	}
}
