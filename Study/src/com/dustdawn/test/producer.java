package com.dustdawn.test;

public class producer extends Thread{
	private product pro ;   //��Ʒ����
	public producer(product pro) {
		this.pro = pro;
	}
	@Override
    public  void run() {
		while(true) {
			try {
				Thread.sleep(3000);    //wait�ͷŶ�������sleep�����ͷŶ�����
			}catch(InterruptedException e){e.printStackTrace();}
			
			pro.produce(); //������Ʒ
			
		}

	}
}

