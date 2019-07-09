package com.csh.java8.lambda.defaultdemo;

public interface MyInterface1 {

    default void myMethod(){
        System.out.println("MyInterface1");
    }
}
