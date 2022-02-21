package com.dustdawn.mianshi;

/**
 * 二分查询
 *
 * @author DUSTDAWN
 * n*(1/2)^x=1,时间复杂度x=log2 n
 */
public class Solution_1 {

    public static void main(String[] args) {
        int nums[] = {-1, 0, 3, 4, 5, 8, 9, 12};
        System.out.println(search(nums, 3));
        System.out.println(search(nums, 4));
    }

    public static int search(int nums[], int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
