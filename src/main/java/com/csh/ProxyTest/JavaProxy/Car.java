package com.csh.ProxyTest.JavaProxy;

/**
 * @desc: car被代理类
 * @author: CuiShiHao
 **/
public class Car implements Moveable{
    @Override
    public void move(String num) {
        System.out.println("汽车前进" + num +"米");
    }

    @Override
    public void back(String num) {
        System.out.println("汽车后退" + num +"米");
    }
}
