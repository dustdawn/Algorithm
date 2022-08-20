package com.dustdawn.thread.producer_consumer;

/**
 * 生产者消费者模型
 * @author dustdawn
 * @date 2022/8/20 17:33
 */
public class ProductConsume {
    public static void main(String[] args) {
        Product product = new Product();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        product.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        product.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "B").start();
    }
}
class Product {
    private int num = 0;
    public synchronized void produce() throws InterruptedException {
        if (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        this.notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        if (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "=>" + num);
        this.notify();
    }
}
