package com.mulanglin.mutil;

/**
 * @Author mulanglin
 * @Date 2020/10/3 20:57
 */
public class Daemontest1 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                for(;;){

                }
            }
        };
        //设置线程为守护线程
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }

}
