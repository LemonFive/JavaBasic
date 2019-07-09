package com.csh.java8.lambda.streamdemo;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class StreamTest5 {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        System.out.println(stream.findFirst().get());

        Stream<Integer> stream = Stream.iterate(1,item -> item + 2).limit(6);
        int sum = stream.filter(item ->item > 2).mapToInt(item ->item  * 2).skip(2).limit(2).sum();
        //orEach(System.out::println);
        System.out.println(sum);
    }
}
