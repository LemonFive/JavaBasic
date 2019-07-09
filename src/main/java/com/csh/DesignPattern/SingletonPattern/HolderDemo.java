package com.csh.DesignPattern.SingletonPattern;

/**
 * @desc: Holder方式 广泛使用的一种单例模式
 * @author: CuiShiHao
 **/
//声明类的时候、成员变量中不声明实例变量，而是放到内部静态类中
public class HolderDemo {

    private HolderDemo(){}

    private static class Holder{
        private static HolderDemo instance = new HolderDemo();
    }

    public static HolderDemo getInstance(){
        return Holder.instance;
    }
}
