package com.dustdawn.DesignPatterns.Creational.AbstractFactory;

/**
 * @author dustdawn
 * @date 2019/11/2 16:10
 */

/**
 * 抽象工厂方法角色
 */
public interface AbstractFactory {
    public AbstractProdustA createProductA();//工厂方法一

    public AbstractProdustB createProductB();//工厂方法二
}
