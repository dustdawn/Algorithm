package com.dustdawn.DesignPatterns.Structural.CompositePattern;

/**
 * @author dustdawn
 * @date 2019/11/7 9:04
 */

/**
 * 抽象构件类角色
 * 抽象文件类
 */
public abstract class AbstractFile {
    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}
