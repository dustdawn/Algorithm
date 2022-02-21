package com.dustdawn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Countint {
    public static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        s = br.readLine();
        return s;
    }

    public static int count(String s) {
        int n = 0;
        boolean isD = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                isD = true;
            } else if (isD) {
                n++;
                isD = false;
            }
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        String s = input();
        System.out.println("" + count(s));
    }
}
