package com.dustdawn.DesignPatterns.Creational.BuilderPattern;

/**
 * @author dustdawn
 * @date 2019/11/4 15:52
 */
public class Client {
    public static void main(String[] args) {
        ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();
        Director director = new Director(concreteBuilder1);
        Product product = director.construct();

    }
}
