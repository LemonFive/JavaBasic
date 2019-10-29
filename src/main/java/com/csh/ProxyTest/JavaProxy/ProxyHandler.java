package com.csh.ProxyTest.JavaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @desc:
 * @author: CuiShiHao
 **/

public class ProxyHandler implements InvocationHandler {
    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始...");
        method.invoke(target,args);
        System.out.println("动态代理结束...");
        return null;
    }
}
