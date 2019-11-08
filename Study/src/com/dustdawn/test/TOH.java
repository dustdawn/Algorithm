package com.dustdawn.test;

import java.util.Scanner;

public class TOH {
	
	public static void main(String[] args) {
 
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入金片数");
		TOH toh=new TOH();
		int n=0;
		try {
			while(scanner.hasNext()){
				n=Integer.parseInt(scanner.next());
			}
			toh.move(n,'a','b','c');
		} catch (Exception e) {
			System.out.println("请输入正整数！！");
			return;
		}
		
	}
 
	public void move(int n, char start, char temp, char target){
		if(n==0) {
            return;
        }
		if(n==1) {
            System.out.println(start+"----->"+target);
        } else{
			move(n-1,start,target,temp);
			System.out.println(start+"----->"+target);
			move(n-1,temp,start,target);
		}
	}
}

