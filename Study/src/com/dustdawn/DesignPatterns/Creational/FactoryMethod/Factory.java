package com.dustdawn.DesignPatterns.Creational.FactoryMethod;

import com.dustdawn.DesignPatterns.Creational.SimpleFactory.Product;

/**
 * @author dustdawn
 * @date 2019/10/31 16:22
 */
public interface Factory {
    //抽象工厂，可以是接口，也可以是抽象类或者具体类
    public Product factoryMethod();
}
