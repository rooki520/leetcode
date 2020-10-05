package com.mulanglin.design.factory;

/**
 * 工厂方法模式
 * 对简单工厂模式的改进，去掉了简单工厂模式的工厂方法（如，createFruit()）的静态属性，使得该方法能被子类继承，
 * 将简单工厂模式中在静态工厂方法中创建对象的操作转移到各子类中完成，从而减轻了父类方法的负担
 * 四个角色：
 * 1）抽象工厂类（AbstractFactory）:工厂方法模式的核心，是具体工厂必须实现的接口或者必须继承的抽象父类
 * 2）具体工厂类（ConcreteFactory）:有具体的类实现，用于创建工厂类的对象，他必须实现抽象工厂的方法
 * 3）抽象产品类（Product）:具体产品继承的抽象父类或者实现的接口，定义了产品类的方法
 * 4）具体产品类（ProductA）:具体工厂类产生的对象就是具体产品类的对象
 * @Author mulanglin
 * @Date 2020/10/4 12:33
 */
//抽象工厂类
abstract class FruitCompany{
    public abstract Fruit createFruit();//声明一个统一的水果的生产方法
}
//具体苹果工厂类
class AppleFactory extends FruitCompany{
    @Override
    public Fruit createFruit(){
        Fruit fruit = new Apple();
        return fruit;
    }
}
//具体香蕉工厂类
class BananaFactory extends FruitCompany{
    @Override
    public Fruit createFruit(){
        Fruit fruit = new Banana();
        return fruit;
    }
}
////抽象产品类
//abstract class Fruit{
//    public Fruit(){}
//    public abstract void operateFruit();
//}
//具体产品类，苹果
//class Apple extends Fruit{
//    //具体产品类--苹果
//    @Override
//    public void operateFruit() {
//        //实现苹果的具体处理方法，这里打印一个字符串
//        System.out.println("this is an Apple");
//    }
//}
//class Banana extends Fruit{
//    //具体产品类--香蕉
//    @Override
//    public void operateFruit() {
//        //实现香蕉的具体处理方法，这里打印一个字符串
//        System.out.println("this is a Banana");
//    }
//}
public class FactoryMethodOfFruid {
    public static void main(String[] args) {
        //建立苹果工厂对象
        FruitCompany af1 = new AppleFactory();
        //苹果工厂生产苹果
        Fruit newp1 = af1.createFruit();
        newp1.operateFruit();
        FruitCompany af2 = new BananaFactory();
        Fruit newp2 = af2.createFruit();
        newp2.operateFruit();

    }
}
