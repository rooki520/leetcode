package com.mulanglin.design.adapter;

import java.util.jar.JarOutputStream;

/**
 * 适配器模式：
 * 将一个类的接口转化为所需要的另一个接口，适配器模式让原本接口不兼容的类可以相互交互
 *
 * 主要包含以下几类
 * 1）需要适配的类Adaptee：需要进行接口转换的类
 * 2）适配器类Adapter：包装需要适配的类Adaptee，将原接口转换为目标接口
 * 3）目标接口Target：最终要转换的接口，目标可以是具体或丑行的类，也可以是接口
 * @Author mulanglin
 * @Date 2020/10/5 10:08
 */
//定义一个目标接口
interface Target{
    public void request();
}

//定义适配器类，用来包装原接口，直接关联需要适配的类Adaptee
class Adapter implements Target{
    private Adaptee adaptee;
    public Adapter (Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        //调用需要适配的类的方法，完成转换
        adaptee.get();
    }
}

//需要适配的类Adaptee
class Adaptee{
    public void get(){
        System.out.println("这就是被适配的类");
    }
}

public class AdapterMode {
    public static void main(String[] args) {
        //通过适配器产生目标接口
        Target target = new Adapter(new Adaptee());
        //目标接口中调用了被适配类的方法，完成了转换
        target.request();
    }
}
