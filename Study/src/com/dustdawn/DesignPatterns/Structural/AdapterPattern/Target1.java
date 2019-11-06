package com.dustdawn.DesignPatterns.Structural.AdapterPattern;

/**
 * @author dustdawn
 * @date 2019/11/5 16:08
 */

/**
 * 目标接口
 */
public interface Target1 {
    //声明用户所需要的接口，类适配器中只能是接口方法
    public void request();
}
