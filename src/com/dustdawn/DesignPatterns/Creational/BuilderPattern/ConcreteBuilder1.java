package com.dustdawn.DesignPatterns.Creational.BuilderPattern;

/**
 * @author dustdawn
 * @date 2019/11/4 13:42
 */

/**
 * 具体建造类
 */
public class ConcreteBuilder1 extends Builder {

    @Override
    public void buildPartA() {
        super.product.setPartA("A1");
    }

    @Override
    public void buildPartB() {
        super.product.setPartB("B1");
    }

    @Override
    public void buildPartC() {
        super.product.setPartC("C1");
    }
}
