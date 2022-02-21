package com.dustdawn.test;

import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.next().split(",");
        //int a = sc.nextInt();
        //int b = sc.nextInt();
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int temp;
        int m = a, n = b;
        if (a > b) {
            while (a % b != 0) {
                temp = a % b;
                a = b;
                b = temp;
            }
            System.out.println(b + "");
            System.out.println((m / b * n) + "");
        } else {
            while (b % a != 0) {
                temp = b % a;
                b = a;
                a = temp;
            }
            System.out.println(a + "");
            System.out.println((m / a * n) + "");
        }

    }
}
