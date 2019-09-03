package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/3 8:47
 */

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class ArraySearch {
    //暴力二分法查询每一行 O(n* log n)
    /*public static boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int left = 0;
                int right = array.length-1;
                int mid;
                while(left <= right) {
                    mid = (left + right) / 2;
                    if(array[i][mid] > target) {
                        right = mid-1;
                    }else if(array[i][mid] < target){
                        left = mid+1;
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;
    }*/

    //矩阵是有序的：利用二维数组由上到下，由左到右递增的规律。
    //那么选取右上角或者左下角的元素a[row][col]与target进行比较，
    //当target小于元素a[row][col]时，那么target必定在元素a所在列的左边,即col--；
    //当target大于元素a[row][col]时，那么target必定在元素a所在行的下边,即row++
    //O(n)
    public static boolean Find(int target, int array[][]) {
        int row = array.length;//行数
        int col = array[0].length;
        if(col == 0 || target < array[0][0] || target > array[row-1][col-1]) {
            return false;
        }
        for (int i = 0, j = col-1; i < row && j >= 0;) {
            if(array[i][j] > target) {
                j--;
            }else if(array[i][j] < target) {
                i++;
            }else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {

        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7,array));
        System.out.println(Find(1,array));

    }
}
