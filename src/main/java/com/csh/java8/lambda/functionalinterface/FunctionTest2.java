package com.csh.java8.lambda.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @desc: 实现多个Function之间的串联
 * @author: CuiShiHao
 **/
public class FunctionTest2 {

    public static void main(String[] args){
        FunctionTest2  test = new FunctionTest2();
        System.out.println(test.compute(5,value -> value * 3, value -> value +10));
        System.out.println(test.compute2(5,value -> value * 3, value -> value +10));


        System.out.println(test.compute3(6,3,(value1,value2) ->value1 + value2));
        System.out.println(test.compute3(6,3,(value1,value2) ->value1 - value2));

        System.out.println(test.compute4(6,3,(value1,value2) ->value1 + value2,value ->value * value));
    }

    public int compute(int a, Function<Integer, Integer> function1,Function<Integer, Integer> function2){
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1,Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> bifunction){
        return bifunction.apply(a,b);
    }

    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> bifunction,Function<Integer,Integer> function){
        return bifunction.andThen(function).apply(a,b);
    }
}
