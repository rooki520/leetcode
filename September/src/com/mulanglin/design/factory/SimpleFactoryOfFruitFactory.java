package com.mulanglin.design.factory;

/**
 * 简单工厂模式
 * 专门定义一个类来负责创建其他类的实例，同时被创建的实例具有共同对象
 * 三个重要的角色
 * 1） 简单工厂类（Simplefactory）:只包含创建产品的静态方法
 * 2）抽象产品父类（Product）:简单工厂类中生产的产品接口，声明了产品的抽象方法
 * 3）具体产品子类（ProductA或ProductB）:具体产品的实现
 * @Author mulanglin
 * @Date 2020/10/4 10:50
 */
//简单工厂类
class FruitFactory{
    //静态方法，根据传入的参数来指定要实例化哪一种产品
    public static Fruit createFruit(String pType){
        Fruit fruit = null;
        //如果参数等于“A”则实例化苹果
        if("A".equals(pType)){
            fruit = new Apple();
        }else if("B".equals(pType)){//如果参数等于“B”则实例化香蕉
            fruit = new Banana();
        }
        return fruit;
    }
}
abstract class Fruit{
    //抽象产品父类，它规定了水果的处理方法
    public Fruit(){}
    //声明水果的处理方法
    public abstract void operateFruit();
}
class Apple extends Fruit{
    //具体产品类--苹果
    @Override
    public void operateFruit() {
        //实现苹果的具体处理方法，这里打印一个字符串
        System.out.println("this is an Apple");
    }
}
class Banana extends Fruit{
    //具体产品类--香蕉
    @Override
    public void operateFruit() {
        //实现香蕉的具体处理方法，这里打印一个字符串
        System.out.println("this is a Banana");
    }
}
public class SimpleFactoryOfFruitFactory {
    public static void main(String[] args) {
        Fruit newP = null;
        //调用工厂方法，生产一个苹果
        newP=FruitFactory.createFruit("A");
        newP.operateFruit();
        //调用工厂方法，生产一个香蕉
        newP=FruitFactory.createFruit("B");
        newP.operateFruit();
    }
}
