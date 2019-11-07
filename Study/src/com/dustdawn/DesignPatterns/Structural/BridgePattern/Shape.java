package com.dustdawn.DesignPatterns.Structural.BridgePattern;

/**
 * @author dustdawn
 * @date 2019/11/6 14:42
 */

/**
 * 抽象类角色
 * 画图类
 */
public abstract class Shape {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }
    public abstract void draw();
}
