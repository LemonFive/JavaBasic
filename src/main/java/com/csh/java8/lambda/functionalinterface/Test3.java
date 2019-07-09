package com.csh.java8.lambda.functionalinterface;

import java.lang.FunctionalInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class Test3 {

    public static void main(String[] args){

        Test3Interface1 t1 = () ->{ System.out.println("inteerface1的method1方法");};

        t1.myMethod1();

        Thread thread = new Thread(() -> System.out.println("helloworld"));
        thread.run();

        new Thread(() -> System.out.println("helloworld2")).start();


        List<String> list = Arrays.asList("hello","world","helloworld");

        List<String> list2 = new ArrayList<>();
        list.forEach(item -> {
            list2.add(item.toUpperCase());
        });

        list2.forEach(item -> {
            System.out.println(item);
        });

        //stream 的方式编写
        list.stream().map(item ->item.toUpperCase()).forEach(item -> System.out.println(item));
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        Function<String,String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
    }
}

@FunctionalInterface
interface  Test3Interface1{

    void myMethod1();
}

@FunctionalInterface
interface  Test3Interface2{

    void myMethod2();
}
