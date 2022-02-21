package com.dustdawn.DesignPatterns.Structural.BridgePattern;

/**
 * @author dustdawn
 * @date 2019/11/6 16:22
 */

/**
 * 具体实现类
 */
public class Black implements Color {
    //实现了 实现类接口 的基本操作方法
    @Override
    public void paint(String shape) {
        System.out.println("黑色的" + shape);
    }
}
