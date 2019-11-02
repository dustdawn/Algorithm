package com.dustdawn.test;

public class BubbleSort {
	public static int[] sort(int arr[]) {
		int l = arr.length;
		int temp;
		for(int i=0;i<l-1;i++) {
			for(int j=0;j<l-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
				
			}
		}
		return arr;
	}
	public static void main(String args[]) {
		int array[] = {6,3,8,2,9,1};
		int result[]=sort(array);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]);
		}
		
	}
}
