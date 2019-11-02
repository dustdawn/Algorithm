package com.dustdawn.test;

public class consumer extends Thread{
	private product pro ;   //��Ʒ����
	public consumer(product pro) {
		this.pro = pro;
	}
	public  void run() {
		while(true) {
			try {
				Thread.sleep(3000);    //wait�ͷŶ�������sleep�����ͷŶ�����
			}catch(InterruptedException e){e.printStackTrace();}
			
			pro.consume(); //���Ѳ�Ʒ
			
		}

	}
}
