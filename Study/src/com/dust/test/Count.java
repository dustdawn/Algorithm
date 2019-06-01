package com.dust.test;
import java.io.*;

public class Count {
	public static String[] input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=new String[10];
		for(int i=0;i<s.length;i++) {
			System.out.println("�������"+(i+1)+"������:");
			s[i]=br.readLine();
		}
		return s;
	}
	public static int countW(String[] s) {
		int n=0;
		for(int i=0;i<s.length;i++) {
			if(s[i].charAt(0)=='w') {
				n++;
			}
		}
		return n;
	}
	
	public static int countOR(String[] s) {
		int n=0;
		for(int i=0;i<s.length;i++) {
			if(s[i].contains("or")) {
				n++;
			}
		}
		return n;
	}
	
	public static int length_3(String[] s) {
		int n=0;
		for(int i=0;i<s.length;i++) {
			if(s[i].length()==3) {
				n++;
			}
			
		}
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		String s[]=input();
		System.out.println("w's count="+countW(s));
		System.out.println("or's count="+countOR(s));
		System.out.println("length=3's count="+length_3(s));
	
	}
}
