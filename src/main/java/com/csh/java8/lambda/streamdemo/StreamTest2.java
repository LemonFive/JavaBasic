package com.csh.java8.lambda.streamdemo;

import java.util.stream.IntStream;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class StreamTest2 {
    public static void main(String[] args) {
        IntStream.of(new int[]{5,6,7}).forEach(System.out::println);

        IntStream.range(3,9).forEach(System.out::println);
    }
}
