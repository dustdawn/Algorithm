package com.dustdawn.test;

public class NineByNineMul {
    public static void main(String args[]) {
        int row = 9;
        int column = 9;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
