package com.dustdawn.test;

public class producer_consumer {
	public static void main(String[] args) {
		product pro = new product();
		producer pThread = new producer(pro);
		consumer cThread = new consumer(pro);
		//pThread.start();
		//cThread.start();
		Thread t1 = new Thread(pThread,"�������߳�");
		Thread t2 = new Thread(cThread,"�������߳�");
		t1.start();
		t2.start();
		
	}
}