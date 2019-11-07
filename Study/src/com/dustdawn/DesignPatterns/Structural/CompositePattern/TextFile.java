package com.dustdawn.DesignPatterns.Structural.CompositePattern;

/**
 * @author dustdawn
 * @date 2019/11/7 9:06
 */

/**
 * 叶子构件类角色
 * 文本文件类
 */
public class TextFile extends AbstractFile{
    private String name;
    public TextFile(String name) {
        this.name = name;
    }
    //由于为叶子构件，没有子结点，不支持对子构件的操作
    @Override
    public void add(AbstractFile file) {
        System.out.println("不支持此操作");
    }
    @Override
    public void remove(AbstractFile file) {
        System.out.println("不支持此操作");
    }
    @Override
    public AbstractFile getChild(int i) {
        System.out.println("不支持此操作");
        return null;
    }
    @Override
    public void killVirus() {
        System.out.println("对文本文件"+ name + "杀毒");
    }
}
