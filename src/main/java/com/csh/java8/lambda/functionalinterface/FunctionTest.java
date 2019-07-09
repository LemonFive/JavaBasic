package com.csh.java8.lambda.functionalinterface;

import java.util.function.Function;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class FunctionTest {

    private static Function<Integer,Integer> function = value ->value + 100;

    public static void main(String[] args){
        FunctionTest test = new FunctionTest();

        System.out.println(test.compute(1,value -> {return 2 * value;}));
        System.out.println(test.compute(2,value ->  value + 5));

        System.out.println(test.compute(7,function));
    }

    public int compute(int a,Function<Integer, Integer> function){
        int result = function.apply(a);

        return result;
    }


}
