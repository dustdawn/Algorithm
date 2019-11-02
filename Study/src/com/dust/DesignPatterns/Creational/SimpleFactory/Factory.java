package com.dust.DesignPatterns.Creational.SimpleFactory;

/**
 * @author dustdawn
 * @date 2019/10/31 16:04
 */
public class Factory {
    //静态工程方法
    public static Product getProduct(String arg) {
        Product product = null;
        //忽略大小写
        if (arg.equalsIgnoreCase("A")) {
            product = new ConcreteProductA();
        }else if (arg.equalsIgnoreCase("B")) {
            product = new ConcreteProductB();
        }
        return product;
    }

    public static void main(String[] args) {
        Product product;
        product = Factory.getProduct("A");
        product.methodSame();
        product.methodDiff();
    }
}
