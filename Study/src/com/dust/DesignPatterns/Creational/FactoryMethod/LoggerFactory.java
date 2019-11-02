package com.dust.DesignPatterns.Creational.FactoryMethod;

/**
 * @author dustdawn
 * @date 2019/11/2 14:51
 */

/**
 * 日志记录器工厂接口，充当抽象工厂角色
 */
public interface LoggerFactory {
    //抽象工厂方法
    public Logger createLogger();
}
