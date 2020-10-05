package com.mulanglin.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 定义了一种一对多的依赖关系，主要思想是让多个观察者对象同时监听某一个主题对象，当主题对象状态发生改变
 * 时，通知所有观察者对象，让他们自己更新自己
 *
 * 主要包含以下类
 * 1）抽象主题角色：提供一系列接口，可以增加和删除观察者角色，也可以将自身的变化通知观察者角色
 * 2）抽象观察者角色：为具体观察者提供了一个接口，当主题有变更通知时更新观察者自己
 * 3）具体主题角色：实现了抽象主题角色，当主题发生变化时，给所有登记的观察者发出通知
 * 4）具体观察者角色：实现了抽象观察者的接口，接受具体主题对象的通知并更新自己
 * @Author mulanglin
 * @Date 2020/10/5 9:47
 */
//抽象观察者角色，定义了一个接口，接口中声明了观察者的方法
interface Observer{
    public void update(String str);
}

//具体观察者角色，实现抽象观察者接口
class ConcreteObserver implements Observer{
    private String observerstr;
    @Override
    public void update(String str) {
        observerstr = str;
        System.out.println("观察者的状态为：" + observerstr);
    }
}

//抽象主题角色，接口中声明了观察者添加或移除的方法
interface Subject{
    public void addObserver(Observer observer); //添加观察者
    public void remmoveObserver(Observer observer);//删除观察者
    public void notifyObserver(String str);//通知观察者
}

//具体主题角色，实现主题接口，具体实现抽象主题的方法，对观察者进行增删改
class ConcreteSubject implements  Subject{
    private List<Observer> list = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void remmoveObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver(String str) {
        for(Observer observer:list){
            observer.update(str);
        }
    }
}
public class ObserverMode {
    public static void main(String[] args) {
        Subject sj = new ConcreteSubject();
        Observer ob1 = new ConcreteObserver();
        Observer ob2 = new ConcreteObserver();
        sj.addObserver(ob1);
        sj.addObserver(ob2);
        sj.notifyObserver("开始观察");
    }
}
