package com.dustdawn.mianshi;

/**
 * 斐波那契数列
 *
 * @author DUSTDAWN
 */
public class Solution_6 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(-10));
        System.out.println(FiBest(-10));
    }

    /**
     * 时间复杂度O(2^n)
     *
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 时间复杂度O(n)
     *
     * @param n
     * @return
     */
    public static int FiBest(int n) {
        int result[] = {0, 1};
        try {
            if (n < 2) {
                return result[n];
            }
        } catch (Exception e) {
            return 0;
        }

        int Fi_one = 0;
        int Fi_two = 1;
        int Fi_n = 0;
        for (int i = 1; i < n; i++) {
            Fi_n = Fi_one + Fi_two;
            Fi_one = Fi_two;
            Fi_two = Fi_n;
        }

        return Fi_n;
    }
}
