package com.dustdawn.DesignPatterns.Creational.FactoryMethod;

/**
 * @author dustdawn
 * @date 2019/11/2 14:53
 */

/**
 * 文件日志记录器工厂类，充当具体工厂角色
 */
public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //创建文件日志记录器对象
        FileLogger fileLogger = new FileLogger();
        //创建文件，代码省略
        return fileLogger;
    }
}
