package com.dust.thread;

/**
 * @author dustdawn
 * @date 2019/9/22 10:05
 */

/**
 * 三个线程轮流打印A-Z
 */
public class forCharacter {
    private static volatile int i = 0;
    private static char ch = 'A';

    /**
     * volatile变量，用来确保将变量的更新操作通知到其他线程。
     *当把变量声明为volatile类型后，编译器与运行时都会注意到这个变量是共享的，
     * 因此不会将该变量上的操作与其他内存操作一起重排序。
     * volatile变量不会被缓存在寄存器或者对其他处理器不可见的地方，
     * 因此在读取volatile类型的变量时总会返回最新写入的值。
     */
    public static void main(String[] args) throws InterruptedException{
        Runnable r = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {

                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        System.out.println("当前：" + threadId);
                        while (i < 26) {
                            if (i % 3 == threadId - 1) {
                                System.out.println("线程id：" + threadId + " " + (char) ch++);
                                i++;

                                if (i == 26) {
                                    System.out.println("完成");
                                }
                                notifyAll();
                            } else {
                                //阻塞其他线程
                                wait();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(r,"1");
        Thread t2 = new Thread(r,"2");
        Thread t3 = new Thread(r,"3");
        t1.start();
        t2.start();
        t3.start();
    }
}
