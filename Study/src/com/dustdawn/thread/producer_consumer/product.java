package com.dustdawn.thread.producer_consumer;

/**
 * @author dustdawn
 * @date 2019/9/22 11:26
 */

/**
 * 产品类
 */
public class product {
    private int n = 0;//产品数量
    private int i = 1, j = 1;//生产消费次数
    private boolean flag = false;//true：消费 false：生产

    public synchronized void produce() {
        System.out.println("剩余产品数量为：" + n);
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        if (flag) {//进行消费中,生产者线程暂停
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++n;
        System.out.println("已生产" + (i++) + "次");
        flag = true;//转为消费阶段，消费进行
        notify();//唤醒消费者方法线程
    }

    public synchronized void consume() {
        System.out.println("剩余产品数量为：" + n);
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        if (!flag) {//进行生产中,消费者线程暂停
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        --n;
        System.out.println("已消费" + (j++) + "次");
        flag = false;//转为消费阶段，消费进行
        notify();//唤醒生产者方法线程
    }
}
