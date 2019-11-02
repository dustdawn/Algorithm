package com.dustdawn.mianshi;
/**
 * 两数之和(从整型数组中找出两数，和为目标数)
 * @author DUSTDAWN
 *
 */
public class Solution_5 {
	public static void main(String[] args) {
		int nums[] = {2,7,11,15};
		System.out.println("["+twoSum(nums,9)[0]+","+twoSum(nums,9)[1]+"]");

	}
	public static int[] twoSum(int[] nums, int target) {
		int result[] = {0,0};
		int size = nums.length;
		for(int i = 0;i<size-1;i++) 
			for(int j = 1;j<size;j++) 
				if (nums[i]+nums[j] == target) {
					result[0]=nums[i];
					result[1]=nums[j];
					
				}
					
		return result;
	}
		
}
	

