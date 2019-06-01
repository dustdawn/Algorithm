package com.dust.test;

public class product {
	private int n = 0;
	private boolean flag= false;
	private int i=1,j=1;
	
	public synchronized void produce() {
		System.out.println("ʣ���Ʒ��:"+n);
		System.out.println(Thread.currentThread().getName()+"��ʼִ��");
		if(flag) {
			//������в�Ʒ�����������̵߳ȴ�
			try {
				wait();
			}catch(InterruptedException e) {e.printStackTrace();}
		}
		n++;  //����޲�Ʒ��������Ʒ
		System.out.println("������"+(i++)+"��");
		flag = true;
		notify();  //����������������߳�
	}
	
	public synchronized void consume() {
		System.out.println("ʣ���Ʒ��:"+n);
		System.out.println(Thread.currentThread().getName()+"��ʼִ��");
		if(!flag) {
			//����޲�Ʒ�����������̵߳ȴ�
			try {
				wait();
			}catch(InterruptedException e) {e.printStackTrace();}
		}
		n--;
		System.out.println("������"+(j++)+"��");
		flag = false;
		notify();
	}
	
	
}
