package com.dustdawn.DesignPatterns.Creational.PrototypePattern;

/**
 * @author dustdawn
 * @date 2019/11/4 15:58
 */

/**
 * 具体原型类
 */
public class ConcretePrototype extends Prototype {
    private String str;//成员变量

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype();
        ((ConcretePrototype) prototype).setStr(this.str);
        return prototype;
    }

}
