package com.mulanglin.design.factory;

/**
 * 抽象工厂模式
 * 提供了一个创建一系列相关或者相互依赖对象的接口
 * 抽象工厂针对对个产品，工厂方法针对的是一种产品的创建模式
 * 四个主要角色
 * 1）抽象工厂类（AbstractFactory）:模式的核心，是具体工厂必须实现的接口或者必须继承的抽象父类
 * 2）具体工厂类（ConcreteFactory）:有具体的类实现，用于创建工厂类的对象，他必须实现抽象工厂的方法
 * 3）抽象产品类（Product）:具体产品继承的抽象父类或者实现的接口，定义了产品类的方法
 * 4）具体产品类（ProductA）:具体工厂类产生的对象就是具体产品类的对象。每一个抽象产品都可以有多个具体产品实现类
 * 或者继承子类，称为产品族
 * @Author mulanglin
 * @Date 2020/10/4 13:02
 */
//抽象工厂，成立一个水果集团类，生产水果和果脯
abstract class FruitGroup{
    //生产水果的方法
    public abstract Fruit createFruit();
    //生产果脯的方法
    public abstract DriedFruit createDriedFruit();
}
////抽象产品类，水果产品的抽象类
//abstract class Fruit{
//    //抽象方法
//    public abstract void operateProduct();
//}
//抽象产品类，果脯产品的抽象类
abstract class DriedFruit{
    //定义抽象方法
    public abstract void operateProduct();
}

//具体工厂，苹果（苹果和苹果脯）
class AppleFactory1 extends FruitGroup{
    @Override
    public Fruit createFruit() {
        return new Apple();
    }

    @Override
    public DriedFruit createDriedFruit() {
        return new DriedApple();
    }
}

//具体工厂，香蕉（香蕉和香蕉果脯）
class BananaFactory1 extends FruitGroup{
    @Override
    public Fruit createFruit() {
        return new Banana();
    }

    @Override
    public DriedFruit createDriedFruit() {
        return new DriedBanana();
    }
}

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

//具体产品类，苹果果脯
class DriedApple extends DriedFruit{
    @Override
    public void operateProduct() {
        //实现苹果果脯的具体处理方法，这里打印一个字符串
        System.out.println("this is a DriedApple");
    }
}

//具体产品类，香蕉果脯
class DriedBanana extends DriedFruit{
    @Override
    public void operateProduct() {
        //实现苹果果脯的具体处理方法，这里打印一个字符串
        System.out.println("this is a DriedBanana");
    }
}
public class AbstractFactoryOfFruit {
    public static void main(String[] args) {
        FruitGroup af1 = new AppleFactory1();
        Fruit newp1 = af1.createFruit();
        DriedFruit newp2 = af1.createDriedFruit();
        newp1.operateFruit();
        newp2.operateProduct();
        FruitGroup af2 = new BananaFactory1();
        newp1 = af2.createFruit();
        newp2 = af2.createDriedFruit();
        newp1.operateFruit();
        newp2.operateProduct();
    }
}
