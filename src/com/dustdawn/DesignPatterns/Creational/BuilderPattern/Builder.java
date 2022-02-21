package com.dustdawn.DesignPatterns.Creational.BuilderPattern;

/**
 * @author dustdawn
 * @date 2019/11/4 13:39
 */

/**
 * 抽象建造者类
 */
public abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品角色
    public Product getResult() {
        return product;
    }
}
