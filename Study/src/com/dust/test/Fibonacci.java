package com.dust.test;

public class Fibonacci {
	public static int Fi(int n) {
		if(n==1||n==2)
			return 1;
		
		return Fi(n-1)+Fi(n-2); 
	}
	public static void main(String[] args) {
		int i;
	
		for(i=0;i<10;i++) {
			System.out.println("Fi["+i+"]="+Fi(i+1));
		}
		
		
		
		int[] Fib=new int[5];
		Fib[0]=Fib[1]=1;
		for(i=2;i<5;i++) {
			Fib[i]=Fib[i-1]+Fib[i-2];
		}
		for(i=0;i<Fib.length;i++) {
			System.out.println("Fib["+i+"]="+Fib[i]);
		}
		long temp=(int)3.9;
		System.out.println(temp+"");
		
		char ch=66;
		System.out.println(ch+"");
		
	}
}
