package com.csh.java8.lambda.functionalinterface;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class PredicateTest {

    public static void main(String[] args){

        Predicate<String> predicate = p -> p.length() > 5;

        System.out.println(predicate.test("helloworld"));
    }

    @Test
    public void predicateTest2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        PredicateTest test = new PredicateTest();

        test.condtionFilter(list,item -> item >4);
        System.out.println("-----------------------------");
        test.condtionFilter(list,item -> item % 2 ==0);
        System.out.println("-----------------------------");

        List<Integer> newList = list.stream().filter(item -> item >4).collect(Collectors.toList());
        newList.forEach(item -> System.out.println(item));

        test.condtionFilter2(list,item -> item >4,item -> item % 2 ==0);
        System.out.println("-----------------------------");
    }


    private void condtionFilter(List<Integer> list,Predicate<Integer> predicate){
        list.forEach(item -> {
            if(predicate.negate().test(item)){
                System.out.println(item);
            }
        });
    }

    /**
    * @description  函数表达式与操作
    * @author  CuiShiHao
    * @date    2019/5/14
    */
    private void condtionFilter2(List<Integer> list,Predicate<Integer> predicate1 ,Predicate<Integer> predicate2){
        list.forEach(item -> {
            if(predicate1.and(predicate2).test(item)){
                System.out.println(item);
            }
        });
    }
}
