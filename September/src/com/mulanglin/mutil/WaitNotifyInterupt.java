package com.mulanglin.mutil;


/**
 * @Author mulanglin
 * @Date 2020/10/2 10:58
 */
public class WaitNotifyInterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("--begin--");
                    synchronized (obj){
                        obj.wait();
                    }
                    System.out.println("--end--");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadA.start();
        //主线程睡眠一秒
        Thread.sleep(1000);
        System.out.println("--begin interrupt threadA--");
        threadA.interrupt();
        System.out.println("--end interrupt threadA--");
    }
}
