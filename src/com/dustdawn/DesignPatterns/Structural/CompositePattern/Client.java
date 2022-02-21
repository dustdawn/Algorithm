package com.dustdawn.DesignPatterns.Structural.CompositePattern;

/**
 * @author dustdawn
 * @date 2019/11/7 9:17
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile file1, file2, file3, file4, folder1;
        file1 = new TextFile("文本文件1");
        file2 = new TextFile("文本文件2");
        file3 = new VideoFile("视频文件1");
        file4 = new VideoFile("视频文件2");
        folder1 = new Folder("文件夹1");
        folder1.add(file1);
        folder1.add(file2);
        folder1.add(file3);
        folder1.add(file4);

        folder1.killVirus();
    }
}
