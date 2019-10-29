package com.csh.ProxyTest.JavaProxy;

/**
 * @desc: car被代理类
 * @author: CuiShiHao
 **/
public class Car implements Moveable{
    @Override
    public void move(String num) {
        System.out.println("汽车行驶" + num +"米");
    }
}
