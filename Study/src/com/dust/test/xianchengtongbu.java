package com.dust.test;

public class xianchengtongbu implements Runnable {
	public static void main(String[] args) {
		Thread t1=new Thread(new xianchengtongbu());
		Thread t2=new Thread(new xianchengtongbu());
		
		t1.start();
		t2.start();
	}
	public void run() {
		Sync.print();
	}
}
	class Sync {
		public static synchronized void print() {
			try {
				for(int i=10;i<=15;i++) {
					System.out.print(i);
				if(i!=15)
					System.out.print(",");
					Thread.sleep(500);
				}
				System.out.println();
			}catch(Exception e) {e.printStackTrace();}
		}
	}
