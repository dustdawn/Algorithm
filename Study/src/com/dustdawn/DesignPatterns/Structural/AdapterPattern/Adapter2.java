package com.dustdawn.DesignPatterns.Structural.AdapterPattern;

/**
 * @author dustdawn
 * @date 2019/11/5 16:19
 */

/**
 * 对象适配器
 */
public class Adapter2 extends Target2 {
    ///包装类Adapter，包装了一个适配者类的实例，
    // 从而将客户端与适配者进行联系
    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        //转发调用适配者类实例对象的方法
        adaptee.specificRequest();
    }
}
