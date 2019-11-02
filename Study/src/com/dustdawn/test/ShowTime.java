package com.dustdawn.test;
import java.util.Date;
import java.text.SimpleDateFormat;;
public class ShowTime {
	public static void main(String[] args) {
		MyShow t1 = new MyShow(1);
		MyShow t2 = new MyShow(5);
		t1.start();
		t2.start();
	}
}
	class MyShow extends Thread{
		private int internal;
		public MyShow(int i) {
			this.internal=i;
		}
		public synchronized void run() {
			while(true){
				try {
					SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
					Date dt=new Date();
					System.out.println(this.getName()+"��ǰʱ��--"+sdf.format(dt));
					sleep(internal*1000);
				}catch(Exception e) {e.printStackTrace();}
			}
		}
	}
