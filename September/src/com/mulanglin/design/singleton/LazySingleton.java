package com.mulanglin.design.singleton;

/**
 * 懒汉式单例模式
 * 调用取得实例的方法时才会实例化一个对象
 * @Author mulanglin
 * @Date 2020/10/4 10:39
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}
    public synchronized LazySingleton getInstance(){
        if(null == instance){
            instance = new LazySingleton();
        }
        return instance;
    }
}
