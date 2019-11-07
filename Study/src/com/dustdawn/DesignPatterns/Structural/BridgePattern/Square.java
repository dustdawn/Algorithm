package com.dustdawn.DesignPatterns.Structural.BridgePattern;

/**
 * @author dustdawn
 * @date 2019/11/6 16:26
 */

/**
 * 抽象扩充类
 * 正方形类
 */
public class Square extends Shape{
    @Override
    public void draw() {
        color.paint("正方形");
    }
}
