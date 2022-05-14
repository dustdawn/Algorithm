package com.dustdawn.DesignPatterns.Creational.SingletonPattern;

/**
 * 饿汉式单例模式
 * 没有加锁，但浪费资源，执行效率高
 *
 * @author dustdawn
 * @date 2019/11/5 14:48
 */

public class SingletonII {
    private static SingletonII instance = new SingletonII();//静态私有成员变量

    //私有构造函数
    private SingletonII() {
    }

    //静态共有工厂方法，返回唯一实例
    public synchronized static SingletonII getInstance() {
        return instance;
    }
}
