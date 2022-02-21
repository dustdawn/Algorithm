package com.dustdawn.DesignPatterns.Creational.SingletonPattern;

/**
 * @author dustdawn
 * @date 2019/11/5 14:51
 */

/**
 * 静态内部类实现单例模式（登记类）
 */
public class SingletonIII {
    //通过静态内部类初始化的静态成员返回单例
    private static class SingletonHandler {
        private static SingletonIII instance = new SingletonIII();
    }

    private SingletonIII() {
    }

    //在调用getInstance方法才初始化静态类
    public static SingletonIII getInstance() {
        return SingletonHandler.instance;
    }
}
