package com.mulanglin.design.singleton;


/**
 * 饿汉式单例模式
 * 在单例类被加载时，就实例化一个对象
 * @author mulanglin
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
