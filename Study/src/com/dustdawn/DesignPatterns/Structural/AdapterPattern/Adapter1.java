package com.dustdawn.DesignPatterns.Structural.AdapterPattern;

/**
 * @author dustdawn
 * @date 2019/11/5 16:08
 */

/**
 * 类适配器
 */
public class Adapter1 extends Adaptee implements Target1 {
    //适配器和适配者是继承关系，称为类适配器模式
    @Override
    public void request() {
        super.specificRequest();
    }
}
