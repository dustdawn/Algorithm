package com.dustdawn.DesignPatterns.Creational.PrototypePattern;

/**
 * @author dustdawn
 * @date 2019/11/4 16:04
 */
public class ConcretePrototypeII implements Cloneable{
    public Prototype clone() {
        Object object = null;
        try {
            object = super.clone();
        }catch (CloneNotSupportedException e) {
            System.err.println("Not support cloneable");
        }
        return (Prototype) object;
    }
}
