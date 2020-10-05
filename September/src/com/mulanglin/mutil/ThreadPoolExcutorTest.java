package com.mulanglin.mutil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author mulanglin
 * @Date 2020/10/4 9:45
 */
public class ThreadPoolExcutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        for(int i=0;i<10;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": 开始执行");
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + ": 结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
