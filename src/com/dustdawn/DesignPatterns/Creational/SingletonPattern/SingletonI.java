package com.dustdawn.DesignPatterns.Creational.SingletonPattern;

/**
 * @author dustdawn
 * @date 2019/11/5 14:42
 */

/**
 * 懒汉式单例模式
 * 线程安全，第一次调用初始化，避免资源浪费，
 * 但必须加锁才能保证单例，加锁影响效率
 */
public class SingletonI {
    private static SingletonI instance = null;//静态私有成员变量

    //私有构造函数
    private SingletonI() {
    }

    //静态共有工厂方法，返回唯一实例
    //保证线程安全
    public static synchronized SingletonI getInstance() {
        if (null == instance) {
            instance = new SingletonI();
        }
        return instance;
    }
}
