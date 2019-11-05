package com.dustdawn.DesignPatterns.Creational.SingletonPattern;

/**
 * @author dustdawn
 * @date 2019/11/5 15:03
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 场景：
 *  通过一个负载均衡器负责服务器的管理和请求的分支
 */
public class LoadBalancer {
    //负载均衡器单例角色
    private static LoadBalancer instance = null;
    //服务器集合角色
    private List serverList = null;
    //私有构造函数对服务器集合进行初始化
    private LoadBalancer() {
        serverList = new ArrayList();
    }

    public static LoadBalancer getLoadBalancer() {
        if (null == instance) {
            synchronized(LoadBalancer.class) {
                if (null != instance) {
                    instance = new LoadBalancer();
                }
            }
        }
        return instance;
    }
    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }
    //移除服务器
    public void removeServer(String server) {
        serverList.remove(server);
    }
    //获得服务器
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }

}
