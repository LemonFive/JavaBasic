package com.csh.reflection;

import java.lang.reflect.Field;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class getModifiers {

    public static int num=100;

    public final String info ="hello";

    public static void main(String[] ars) throws NoSuchFieldException {
        getModifiers test =new getModifiers();
        Field field1=test.getClass().getField("num");
        int result1=field1.getModifiers();
        System.out.println(result1);
        int m = 8 & result1;
        System.out.println(m);

        Field field2 = test.getClass().getField("info");
        int result2 = field2.getModifiers();
        System.out.println(result2);
        int n = 8 & result2;
        System.out.println(n);
    }
}
