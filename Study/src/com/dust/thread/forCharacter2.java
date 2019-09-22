package com.dust.thread;

/**
 * @author dustdawn
 * @date 2019/9/22 10:07
 */

/**
 * 用五个线程，顺序打印数字1~无穷大，其中每5个数字为1组
 */
public class forCharacter2 {
    private static volatile int orderNum = 1;
    private static Object o = new Object();

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        System.out.println("线程"+Thread.currentThread().getName()+"启动");
                        while (true) {
                            if (orderNum % 5 == threadId || orderNum % 5 == 0) {
                                if (orderNum % 5 == threadId) {//1-4
                                    System.out.println("线程" + threadId + ":" + orderNum++);
                                } else {
                                    System.out.println("线程" + 5 + ":" + orderNum++);
                                }
                                Thread.sleep(2000);
                                System.out.println("当前线程"+threadId+"唤醒阻塞线程了");
                                o.notifyAll();
                            } else {
                                //orderNum与thread不对应就阻塞
                                System.out.println("线程"+threadId+"要阻塞了,释放对象锁");
                                o.wait();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(r, "1");
        Thread t2 = new Thread(r, "2");
        Thread t3 = new Thread(r, "3");
        Thread t4 = new Thread(r, "4");
        Thread t5 = new Thread(r, "5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
