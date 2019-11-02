package com.dust.DesignPatterns.Creational.FactoryMethod;

/**
 * @author dustdawn
 * @date 2019/11/2 14:50
 */

/**
 * 数据库日志记录器，充当具体产品角色
 */
public class DatabaseLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}
