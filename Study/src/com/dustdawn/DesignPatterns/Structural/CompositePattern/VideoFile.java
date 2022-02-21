package com.dustdawn.DesignPatterns.Structural.CompositePattern;

/**
 * @author dustdawn
 * @date 2019/11/7 9:11
 */

/**
 * 叶子构件类角色
 * 视频文件类
 */
public class VideoFile extends AbstractFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

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
        System.out.println("对视频文件" + name + "杀毒");
    }
}
