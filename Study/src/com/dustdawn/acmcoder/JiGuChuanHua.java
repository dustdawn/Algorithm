package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/2 8:24
 */
public class JiGuChuanHua {
    public static void main(String[] args) {
        int n = 3; //人数
        int m = 3; //次数
        transmit(n, m);
    }
    public static void transmit(int n, int m) {
        int[][] arr = new int[m+1][n+1];
        /**
         * 定义 行:次数+1 列:人数+1 的二维数组
         * 表示有n个人，第m次回到原点左右两人的情况之和
         * 停留在每个位置有两个方向走下一步
         * 即1->2 1->n
         * 则走一步回到一个点有两种情况2->1 n->1
         * arr[m][n]等于 m-1次走回原点之和
         * arr[m][n] = arr[m-1][n+1] + arr[m-1][n-1]
         * arr[0][1] = 1;
         * arr[1][2] = 1 = arr[0][1] + arr[0][3](0);
         * arr[2][2] = 1 = arr[1][1] + arr[1][3];
         * arr[m][2] = 1 = arr[m-1][1] + arr[m-1][3];
         */
        //走1次回到原点方式,只能1个人
        arr[0][1] = 1;
        //递归回边界arr[0][1]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(j == 1) {
                    arr[i][1] = arr[i-1][2] + arr[i-1][n];
                }
                else if(j == n) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][1];
                }
                else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1];
                }

            }
        }
        System.out.println(arr[m][1]);




    }

}
