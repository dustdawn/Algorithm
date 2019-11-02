package com.dustdawn.thread.producer_consumer;

/**
 * @author dustdawn
 * @date 2019/9/22 11:41
 */

/**
 * 消费者线程
 */
public class consumer implements Runnable{
    private product pro;

    public consumer(product pro) {
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
            pro.consume();
        }
    }
}
