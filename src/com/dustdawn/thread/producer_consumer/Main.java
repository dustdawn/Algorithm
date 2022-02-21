package com.dustdawn.thread.producer_consumer;

/**
 * @author dustdawn
 * @date 2019/9/22 11:42
 */
public class Main {
    public static void main(String[] args) {
        product pro = new product();
        Thread t1 = new Thread(new producer(pro), "生产者线程");
        Thread t2 = new Thread(new consumer(pro), "消费者线程");
        t1.start();
        t2.start();

    }
}
