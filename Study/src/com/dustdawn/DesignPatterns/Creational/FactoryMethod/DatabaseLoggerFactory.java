package com.dustdawn.DesignPatterns.Creational.FactoryMethod;

/**
 * @author dustdawn
 * @date 2019/11/2 14:52
 */

/**
 * 数据库日志记录器工厂类，充当具体工厂角色
 */
public class DatabaseLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        //连接数据库
        //创建数据库日志记录器对象
        DatabaseLogger databaseLogger = new DatabaseLogger();
        //初始化数据库日志记录器，代码省略
        return databaseLogger;
    }
}
