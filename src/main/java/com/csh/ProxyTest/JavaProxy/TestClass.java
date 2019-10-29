package com.csh.ProxyTest.JavaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @desc: JDK动态代理基于聚合
 * @author: CuiShiHao
 **/
public class TestClass {
    public static void main(String[] args) {
        // Java动态代理测试
        Car car = new Car();
        InvocationHandler invocationHandler = new ProxyHandler(car);
        /**
         * newProxyInstance的第一个参数是类加载器
         * 第二个参数是被代理类实现的接口
         * 第三个参数是InvocationHandler
         */
        Moveable moveable = (Moveable) Proxy.newProxyInstance(car.getClass().getClassLoader(),
                car.getClass().getInterfaces(),invocationHandler);
        moveable.move("100");
    }
}
