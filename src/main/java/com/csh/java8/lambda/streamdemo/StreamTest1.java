package com.csh.java8.lambda.streamdemo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @desc:流的创建
 * @author: CuiShiHao
 **/
public class StreamTest1 {
    public static void main(String[] args) {

        //流的创建
        Stream stream1 = Stream.of("hello","world","helloWorld");
        //数组的方式创建
        String[] myArrays = new String[]{"hello","world","helloWorld"};
        Stream stream2 = Stream.of(myArrays);

        List<String> list = Arrays.asList(myArrays);
        Stream stream3 = list.stream();
    }
}
