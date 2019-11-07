package com.dustdawn.DesignPatterns.Structural.CompositePattern;

/**
 * @author dustdawn
 * @date 2019/11/7 9:13
 */

import java.util.ArrayList;

/**
 * 容器构件类
 * 文件夹类
 */
public class Folder extends AbstractFile{
    //定义集合fileList，用于存储AbstractFile
    private ArrayList<AbstractFile> fileList = new ArrayList<>();
    private String name;
    public Folder(String name) {
        this.name = name;
    }
    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }
    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }
    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }
    @Override
    public void killVirus() {
        System.out.println("对文件夹"+ name + "杀毒");
        for (AbstractFile file : fileList) {
            file.killVirus();
        }
    }
}
