package com.dustdawn.DesignPatterns.Creational.SimpleFactory;

/**
 * @author dustdawn
 * @date 2019/10/31 16:02
 */
public abstract class Product {
    //所有产品类的公共业务方法
    public void methodSame() {

    }

    //声明抽象业务方法
    public abstract void methodDiff();
}
