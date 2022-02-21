package com.dustdawn.mianshi;

/**
 * 八皇后问题
 *
 * @author dustdawn
 * @date 2019/8/29 11:51
 */
public class Solution_10 {
    public static int[][] array = new int[8][8];
    public static int count = 0;

    /*
     * 判断结点是否合适
     */
    public static boolean isCorrect(int m, int n) {
        //行列冲突
        for (int i = 0; i < 8; i++) {
            if (array[i][n] == 1 || array[m][i] == 1) {
                return false;
            }
        }

        //左边对角线
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == 1) {
                return false;
            }
        }

        for (int i = m - 1, j = n + 1; i >= 0 && j < 8; i--, j++) {
            if (array[i][j] == 1) {
                return false;
            }
        }

        //右边对角线
        for (int i = m + 1, j = n - 1; i < 8 && j >= 0; i++, j--) {
            if (array[i][j] == 1) {
                return false;
            }
        }

        for (int i = m + 1, j = n + 1; i < 8 && j < 8; i++, j++) {
            if (array[i][j] == 1) {
                return false;
            }
        }

        return true;

    }

    //每行寻找皇后
    public static void findQueens(int i) {
        if (i > 7) {
            count++;

            System.out.print("方案" + count + ":" + "\n");
            for (int m = 0; m < 8; m++) {
                for (int n = 0; n < 8; n++) {
                    if (array[m][n] == 1) {
                        System.out.print("Q ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
            System.out.println();

            return;

        }
        for (int j = 0; j < 8; j++) {
            if (isCorrect(i, j)) {
                array[i][j] = 1;
                findQueens(i + 1);
                array[i][j] = 0;  //回溯时清0
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("八皇后问题");
        findQueens(0);
        System.out.println("八皇后问题共有：" + count + "种方案");
    }
}
