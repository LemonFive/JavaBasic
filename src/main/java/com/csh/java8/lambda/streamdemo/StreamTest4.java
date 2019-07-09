package com.csh.java8.lambda.streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class StreamTest4 {
    public static void main(String[] args) {

//        List<String> list = Arrays.asList("hello","world","helloWorld");
//        Stream<String> stream= list.stream();
//        String[] array = stream.toArray(String[]::new);
//        Arrays.asList(array).forEach(System.out::println);
//
//        Stream<String> stream2 = Stream.of("hello","world","helloWorld");
//        List<String> list2 = stream2.collect(Collectors.toList());
//        list2.forEach(System.out::println);
//
//        Stream<java.lang.String> stream3 = Stream.of("hello","world","helloWorld");
//        List<String> list = stream.collect(Collectors.toList());

        Stream <List<Integer>> stream = Stream.of(Arrays.asList(1),
                Arrays.asList(2,3),Arrays.asList(4,5,6));

        stream.flatMap(theList ->theList.stream()).map(item ->item * item).forEach(System.out::println);

    }
}

