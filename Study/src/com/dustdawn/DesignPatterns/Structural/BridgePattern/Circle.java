package com.dustdawn.DesignPatterns.Structural.BridgePattern;

/**
 * @author dustdawn
 * @date 2019/11/6 15:04
 */

/**
 * 扩充抽象类
 * 圆形
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        color.paint("圆形");
    }
}
