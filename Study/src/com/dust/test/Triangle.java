package com.dust.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
	private double a,b,c;
	double area;
	public Triangle() {
	}
	public Triangle(double x,double y,double z) {
		this.a=x;
		this.b=y;
		this.c=z;
	}
	public void trifunc() {
		if(a+b>c&&a+c>b&&b+c>a) {
			double p=(a+b+c)/2;
			area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
		}
		else {
			double min=Math.min(a, b);
			min=Math.min(min, c);
			area=min*(Math.sqrt(3))*min/4;
		}
	}
	
	public static void main(String[] args) {
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		double x = Double.parseDouble(s1);
		String s2 = br.readLine();
		double y = Double.parseDouble(s2);
		String s3 = br.readLine();
		double z = Double.parseDouble(s3);
		
		Triangle tr=new Triangle(x,y,z);
		tr.trifunc();
		System.out.println(tr.area);
		}catch(IOException e) {
			
		}
	}
}
