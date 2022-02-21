package com.dustdawn.DesignPatterns.Creational.BuilderPattern;

/**
 * @author dustdawn
 * @date 2019/11/4 13:46
 */

/**
 * 指挥者类
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    //产品构建和组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
