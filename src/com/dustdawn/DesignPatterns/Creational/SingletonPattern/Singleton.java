package com.dustdawn.DesignPatterns.Creational.SingletonPattern;

/**
 * 双重校验锁DCL的线程安全的单例模式
 *
 * @author dustdawn
 * @date 2019/11/5 14:54
 */

public class Singleton {
    // volatile保证线程之间可见性和屏蔽JVM重排序
    // 也会屏蔽一些JVM的代码优化导致运行效率低，所以也不完美
    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        // 第一个if在已创建实例后直接返回实例，不再进入同步代码块竞争锁
        if (instance == null) {
            synchronized (Singleton.class) {
                // 第二个if防止同时通过第一个if的多个线程创建多个实例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
