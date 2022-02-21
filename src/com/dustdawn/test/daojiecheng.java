package com.dustdawn.test;

public class daojiecheng {
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static void main(String args[]) {
        double n = 0;
        for (int i = 1; i <= 15; i++) {
            n += 1.0 / f(i);
        }
        System.out.println("" + n);
    }
}
