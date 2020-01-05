package com.csh.JVM;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @desc: 模拟出JVM Metaspace内存溢出 （动态生成大量的类）【没成功】
 * <p>
 * 配置参数：-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * @author: CuiShiHao
 **/
public class demo7 {
    public static void main(String[] args) throws InterruptedException {
        long count = 0;
        while (true) {
            System.out.println("目前创建了" + (++count) + "个Car类的子类了");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(SafeCar.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (method.getName().equals("run")) {
                        System.out.println("启动汽车之间，先进行自动的安全检查.");
                        return methodProxy.invokeSuper(o, objects);
                    } else {
                        return methodProxy.invokeSuper(o, objects);
                    }
                }
            });

            Car car = (Car) enhancer.create();
            car.run();
        }
    }

    static class Car {

        public void run() {
            System.out.println("汽车启动，开始行驶。。。");
        }
    }

    static class SafeCar extends Car{

        @Override
        public void run() {
            System.out.println("汽车启动，开始行驶。。。");
        }

    }
}
