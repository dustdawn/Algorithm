package com.dust.DesignPatterns.Creational.FactoryMethod;

import com.dust.DesignPatterns.Creational.SimpleFactory.ConcreteProductA;
import com.dust.DesignPatterns.Creational.SimpleFactory.Product;

/**
 * @author dustdawn
 * @date 2019/10/31 16:24
 */
public class ConcreteFactoryA implements Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
