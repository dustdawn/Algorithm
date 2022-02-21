package com.dustdawn.test;

import java.util.Scanner;

public class lingxing {
    public static void main(String str[]) {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();

        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        for (i = n; i >= 0; i--) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
