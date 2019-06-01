package com.dust.test;
import java.util.Calendar;

public class jiecheng {
	public static int func(int n) {
		if(n==1)
			return 1;
		
		return n*func(n-1);
	}
	public static int add(int n) {
		int result = 0;
		for(int i=1;i<=n;i++) {
			result+=func(i);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(""+add(5));
		
	}
}
