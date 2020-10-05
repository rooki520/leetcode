package com.mulanglin.mutil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author mulanglin
 * @Date 2020/10/4 9:56
 */
public class ThreadLocalTest {
    static void print(String str){
        System.out.println(str + ":" + localVariable.get());
        //清除当前线程threadLocal变量
        localVariable.remove();
    }
    static ThreadLocal<String> localVariable = new ThreadLocal<>();
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //set()，haspmap,key是当前ThreadLocal的实例对象引用，value是set方法传递的值
                localVariable.set("threadOne local variable");
                print("threadOne");
                System.out.println("threadOne remove after" + ":" + localVariable.get());
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("threadTwo remove after" + ":" + localVariable.get());
            }
        });
        //关闭线程池
        executorService.shutdown();
    }
}
