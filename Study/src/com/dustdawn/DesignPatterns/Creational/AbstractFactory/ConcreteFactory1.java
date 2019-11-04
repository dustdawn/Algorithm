package com.dustdawn.DesignPatterns.Creational.AbstractFactory;

/**
 * @author dustdawn
 * @date 2019/11/2 16:15
 */

/**
 * 具体工厂角色1
 */
public class ConcreteFactory1 implements AbstractFactory{
    @Override
    public AbstractProdustA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProdustB createProductB() {
        return new ConcreteProductB1();
    }
}
