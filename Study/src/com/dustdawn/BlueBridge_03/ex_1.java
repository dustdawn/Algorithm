package com.dustdawn.BlueBridge_03;

public class ex_1 {
	//数量周期
	public static double func(double x,double r) {
		return x*(1-x)*r;
	}
	public static void main(String[] args) {
		double r = 3.62;
		double x = 0.5;
		for(int i = 0;i<20;i++) {
			x = func(x,r);
			System.out.println(x);
		}
	}
}
