package com.dustdawn.DesignPatterns.Structural.BridgePattern;

/**
 * @author dustdawn
 * @date 2019/11/6 16:24
 */

/**
 * 具体实现类
 */
public class White implements Color{
    @Override
    public void paint(String shape) {
        System.out.println("白色的" + shape);
    }
}
