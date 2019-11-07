package com.dustdawn.DesignPatterns.Structural.BridgePattern;

/**
 * @author dustdawn
 * @date 2019/11/6 16:27
 */

/**
 * 客户端类
 */
public class Client {
    public static void main(String[] args) {
        Color white = new White();
        Shape circle = new Circle();

        circle.setColor(white);
        circle.draw();

    }
}
