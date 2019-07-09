package com.csh.java8.lambda.functionalinterface;

import java.util.function.Supplier;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier =  () -> "helloWorld";
        System.out.println(supplier.get());

        Supplier<Person> supplier1 = () ->new Person("test",12);

        System.out.println();
    }
}
