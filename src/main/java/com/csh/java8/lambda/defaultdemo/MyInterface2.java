package com.csh.java8.lambda.defaultdemo;

public interface MyInterface2 {

    default void myMethod(){
        System.out.println("MyInterface2");
    }
}
