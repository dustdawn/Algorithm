package com.dustdawn.DesignPatterns.Creational.FactoryMethod;

/**
 * @author dustdawn
 * @date 2019/11/2 14:51
 */

/**
 * 文件日志记录器，充当具体产品角色
 */
public class FileLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}
