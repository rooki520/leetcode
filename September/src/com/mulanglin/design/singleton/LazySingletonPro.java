package com.mulanglin.design.singleton;

/**
 * 懒汉式单例模式的改进
 * 1）进入方法后先检查实例是否存在，如果不存在则进入同步块；如果存在则直接返回该实例
 * 2）如果进入了同步块，则再次检查实例是否存在，如果不存在，就在同步代码块中创建实例，如果存在则返回该实例
 * 又被称为“双重检查枷锁机制”
 * @Author mulanglin
 * @Date 2020/10/4 10:43
 */
public class LazySingletonPro {
    private static volatile LazySingletonPro insstance;
    private LazySingletonPro(){}
    public static LazySingletonPro getInstance(){
        //第一次检查
        if(null == insstance){
            synchronized (LazySingletonPro.class){
                //第二次检查
                if(null == insstance){
                    insstance = new LazySingletonPro();
                }
            }
        }
        return insstance;
    }
}
