package com.dust.test;

public class Vxing {
	public static void main(String[] arg) {
		int n=10;
		int i,j,m;
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}
			for(m=0;m<20-2*i;m++) {
				System.out.print(" ");
			}
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
		
	}
}
