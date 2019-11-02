package com.dustdawn.thread.producer_consumer;

/**
 * @author dustdawn
 * @date 2019/9/22 11:36
 */

/**
 * 生产者线程
 */
public class producer implements Runnable{
    private product pro;

    public producer(product pro) {
        this.pro = pro;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pro.produce();
        }
    }
}
