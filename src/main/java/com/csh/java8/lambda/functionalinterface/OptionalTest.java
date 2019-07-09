package com.csh.java8.lambda.functionalinterface;

import java.util.Optional;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");

        if(optional.isPresent()) {
            System.out.println(optional.get());
        }
    }
}
