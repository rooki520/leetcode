package com.mulanglin.mutil;

/**
 * @Author mulanglin
 * @Date 2020/10/4 10:23
 */
//ThreadLocal不支持继承
public class ThreadLocalTest1 {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("Hello");
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("thread:" + threadLocal.get());
            }
        };
        thread.start();
        System.out.println("main:" + threadLocal.get());
    }
}
