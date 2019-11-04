package com.dustdawn.DesignPatterns.Creational.BuilderPattern;

/**
 * @author dustdawn
 * @date 2019/11/4 10:10
 */

/**
 * 复杂产品角色
 */
public class Product {
    private String partA;//部件
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }
}
