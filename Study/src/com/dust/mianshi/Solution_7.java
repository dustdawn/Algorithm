package com.dust.mianshi;

import java.util.Arrays;

/**
 * 排序算法
 * @author DUSTDAWN
 *
 */
public class Solution_7 {
	/**
	 * :冒泡排序  O(n^2)
	 */
	public static void bubbleSort(int[] array) {
		if(array.length ==0)
			return;
		boolean needNextPass = true;
		for(int i = 1;i<array.length;i++) {
			needNextPass = false;
			for(int j = 0;j<array.length-i;j++)
				if(array[j]>array[j+1]) {
					swap(array,j,j+1);
					needNextPass = true;
				}
		
			out("冒泡排序：",i+1,Arrays.toString(array));
		}
				
	}
	/**
	 * :选择排序 选择出最小的比较 O(n^2)
	 */
	public static void selectionSort(int[] array) {
		if(array.length ==0)
			return;
		for(int i = 0;i<array.length;i++){
			int minIndex = i;
			for(int j = i;j<array.length;j++) {
				if(array[j]<array[minIndex])
					minIndex = j;
			}
			//array[i]和array[minIndex]交换
			swap(array,i,minIndex);
			out("选择排序：",i+1,Arrays.toString(array));
		}
	}
	/**
	 * :插入排序 O(n^2)
	 */
	public static void insertSort(int[] array) {
		if(array.length ==0)
			return;
		int current = 0;
		for(int i = 0 ;i<array.length-1;i++) {
			current = array[i+1];
			//前指针索引
			int preIndex = i;
			//当前值比前指针索引对应的值小,则索引继续往前移动
			while(preIndex >= 0 && current <= array[preIndex]) {
				//索引每移动一位之前将比较过的索引对应的值后移
				array[preIndex+1] = array[preIndex];
				preIndex--;
			}
			array[preIndex+1] = current;
			out("插入排序：",i+1,Arrays.toString(array));
		}
	}
	
	/**
	 * :快速排序 
	 * O(n * log2 n)
	 */
	static int count=1;
	public static void quickSort(int[] array,int start,int end) {
		if(array.length<1 || start<0 || end>array.length || start>end)
			return;
			//以第一个元素为基准  两边分为大 小元素  返回值为排序后的中间位置
			int baseIndex = partition(array,start,end);
			out("快速排序：",count++,Arrays.toString(array));
			//将分区后的两列迭代排序
			quickSort(array,start,baseIndex-1);
			
			quickSort(array,baseIndex+1,end);
		
	}
	public static int partition(int[] array,int start,int end) {
		int base = array[start];
		while(start<end) {
			while(start<end && array[end]>=base)
				end--;
			//从后往前找到第一个小于base的元素
			//array[start] = array[end];
			swap(array,start,end);
			
			
			while(start<end && array[start]<=base)
				start++;
			//从前往后找到第一个大于base的元素
			//array[end] = array[start];
			swap(array,start,end);
			
		}
		//array[start] = base;
		return start;
	}
	
	/**
	 * :希尔排序
	 * O(n * log2 n)
	 */
	public static void shellSort(int[] array) {
		int len = array.length;
		//分组
		int gap = len/2;
		int k = 1;
		int current;
		while(gap>0) {
			for(int i = gap;i<len;i++) {
				current = array[i];
				int preIndex = i-gap;
				//直接插入排序
				//当前值比前指针索引对应的值小,则索引继续往前移动
				while(preIndex>=0 && array[preIndex]>current) {
					//索引每移动一位之前将比较过的索引对应的值后移
					array[preIndex+gap] = array[preIndex];
					preIndex -= gap;
				}
				array[preIndex+gap] = current;
			}
			gap/=2;
			out("希尔排序：",k++,Arrays.toString(array));
		}
	}
	
	/**
	 * :归并排序
	 */
	static int count2 = 1;
	//分
	public static int[] mergeSort(int[] array) {
		if(array.length<2)
			return array;
		int mid = array.length/2;
		//分组0到mid-1，mid到lengh-1
		int left[] = Arrays.copyOfRange(array, 0, mid);
		int right[] = Arrays.copyOfRange(array, mid, array.length);
		//归并后的数组
		return merge(mergeSort(left),mergeSort(right));
	}
	//治
	public static int[] merge(int left[],int right[]) {
		int[] result = new int[left.length+right.length];
		/*  8 4 5 7 1 3 6 2
	      8 4 5 7	    1 3 6 2
		8 4     5 7   															分
	   8   4   5 	7		 ------------------------------------							
	  	4 8     5 7																治
	      4 5 7 8
	   		1 2 3 4 5 6 7 8
		*/
		for(int index = 0,i = 0,j = 0;index<result.length;index++) {
			//表示若执行第四个判断left到末尾(所有元素归并到result内)，将right元素归并到result即可
			if(i>=left.length)
				result[index] = right[j++];
			//表示若执行第三个判断right到末尾(所有元素归并到result内)，将left元素归并到result即可
			else if(j>=right.length)
				result[index] = left[i++];
			//第一组中的第i个数比较第二组第j个数
			//则赋值result第index个元素为两组中小的数
			else if(left[i]>right[j])
				result[index] = right[j++];
			else
				result[index] = left[i++];
		}
		out("归并排序：",count2++,Arrays.toString(result));
		return result;
	}
	
	/**
	 * :堆排序 O(n * log2 n
	 * 完全二叉树在满足父结点大于左右子节点则为最大堆 
	 * 完全二叉树下以数组保存后，每个结点序号为0到length-1
	 * 已知结点序号为i，则其父结点为(i-1)/2
	 * 同理，其子结点分别为i*2+1,i*2+2
	 */
	public static void heapSort(int[] array) {
		int len = array.length;
		int k = 1;
		if(len<1)
			return;
		buildMaxHeap(array,len);
		//heapify从上至下，从下至上形成最大堆后根节点一定为最大值
		//循环交换首位和末尾，将换到末尾的最大值移出
		//循环移出的数作为排序后数组的最后一个元素
		for(int i = len-1;i>=0;i--){
			//交换最大值和末尾元素
			swap(array,0,i);
			//每次移出最大值后相当于长度n=i
			heapify(array,i,0);
			out("堆排序：",k++,Arrays.toString(array));
		}
	}
	//从最后子叶的父结点倒序做heapify操作
	//即可完成对整个完全二叉树的heapify
	//最后子叶序号为len-1,其父结点为(len-1-1)/2
	public static void buildMaxHeap(int[] array,int len) {
		for(int i = (len-2)/2;i>=0;i--)
			heapify(array,len,i);
	}
	//对i结点及其子结点组成的部分进行heapify操作，即形成堆操作
	public static void heapify(int[] array,int len ,int i) {
		if(i>=len)
			return;
		int maxIndex = i;
		if(i*2+1<len && array[i*2+1]>array[maxIndex])
			maxIndex = i*2+1;
		if(i*2+2<len && array[i*2+2]>array[maxIndex])
			maxIndex = i*2+2;
		if(maxIndex != i) {
			swap(array,maxIndex,i);
			//对子层作递归heapify操作
			heapify(array,len,maxIndex);
		}
	}
	/**
	 * :二分排序 O(n * log2 n)
	 */
	public static void binarySort(int[] array) {
		int k = 1;
		for(int i = 1;i<array.length;i++) {
			//相当于用二分法每次插入元素到已排好顺序的数组中
			int temp = array[i];//当前待插入元素
			int left = 0;//最左端
			int right = i-1;//最右端
			int mid = 0;
			while(left<=right) {
				mid = (left + right)/2;
				//插入数小于中间数,右端点-1
				if(temp<array[mid])
					right = mid-1;
				else 
					left = mid+1;
			}
			//将前面所有的大于当前插入元素的往后移动
			//i即为当前插入元素的序号
			//插入原理同插入排序
			//此时的left即为数组中第一个小于当前插入元素的序号的下一个
			//即preIndex+1
			for(int j = i-1;j>=left;j--)
				array[j+1] = array[j];
			//插入当前插入元素
			array[left] = temp;
			
			out("二分排序：",k++,Arrays.toString(array));
		}
	}
	/**
	 * :基数排序O(n * k)
	 * 
	 */
	public static void radixSort(int[] array) {
		if(array == null || array.length<2)
			return;
		int len = array.length;
		int count = 1;
		//算出最大数的位数,即为分配回收的次数
		int maxDigit = 1;
		int max = array[0];
		for(int i = 1;i<len;i++) 
			max = max<array[i]?array[i]:max;
		while(max!=0) {
			max/=10;
			maxDigit*=10;
		}
		
		int n = 1;//用于保存个位十位百位的数
		int k = 0;//保存每次回收后的序列中的元素序号

		int[][] bucket = new int[10][len];
		//保存每个桶里的数字数量
		int order[] = new int[10];
		//maxDigit为限制的分配回收次数
		while(n<maxDigit) {
			//分配
			for(int num:array) {
				int digit = (num/n)%10;
				bucket[digit][order[digit]] = num;
				//第digit个桶装有数字的数量加一
				order[digit]++;
			}
			//回收
			for(int i = 0;i<len;i++) {
				if(order[i]!=0)//桶中有数据
					for(int j = 0;j<order[i];j++) {
						//回收基数为i的桶中的第j个元素
						//到回收后的序列中
						array[k] = bucket[i][j];
						k++;
					}
				
				order[i] = 0;//清空桶
			}
			out("基数排序：",count++,Arrays.toString(array));
			n*=10;
			k = 0;
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
	
//main	
	public static void main(String[] args) {
	//冒泡排序
	int array1[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array1));
		bubbleSort(array1);
		System.out.println();
	
	//选择排序	
	int array2[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array2));
		selectionSort(array2);
		System.out.println();
		
	//插入排序	
	int array3[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array3));
		insertSort(array3);
		System.out.println();
		
	//快速排序
	int array4[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array4));
		quickSort(array4,0,array4.length-1);
		System.out.println();
		
	//希尔排序	
	int array5[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array5));
		shellSort(array5);
		System.out.println();
		
	
	//归并排序	
	int array6[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array6));
		mergeSort(array6);
		System.out.println();
			
		
	//堆排序	
	int array7[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array7));
		heapSort(array7);
		System.out.println();
		
	//二分排序	
	int array8[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array8));
		binarySort(array8);
		System.out.println();	
	
	
	//基数排序	
	int array9[] = {66,13,51,76,81,26,57,69,23};
	System.out.println("排序前"+Arrays.toString(array9));
	radixSort(array9);
		System.out.println();	
	}
}
