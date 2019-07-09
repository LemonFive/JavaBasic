package com.csh.java8.lambda.functionalinterface;

import java.lang.FunctionalInterface;
/**
 * @desc:
 * @author: CuiShiHao
 **/
@FunctionalInterface
interface MyInterface{

    void test();

    @Override
    String toString();
}

public class Test2 {

    public void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args){
        Test2 test2 = new Test2();

        test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("my test");
            }
        });

        System.out.println("lambdatest");
        test2.myTest(() -> {
            System.out.println("using lambda");
            System.out.println("my test");
        });
    }
}
