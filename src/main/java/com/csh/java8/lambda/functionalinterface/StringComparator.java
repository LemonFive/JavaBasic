package com.csh.java8.lambda.functionalinterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class StringComparator {

    public static void main(String[] args){
        List<String> names= Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        System.out.println(names);
//        System.out.println("-----------------------------");

        Collections.sort(names, (String o1, String o2) -> {
            return o2.compareTo(o1);
        } );
        System.out.println(names);
        System.out.println("-----------------------------");
    }
}
