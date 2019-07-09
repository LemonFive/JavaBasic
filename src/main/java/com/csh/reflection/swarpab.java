package com.csh.reflection;

import java.lang.reflect.Field;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class swarpab {

    public static void main(String[] args){
        Integer a = 2019;
        Integer b = 2020;
        System.out.println(a + " " + b);
        swarp(a,b);
        System.out.println(a + " " + b);

        Class c = "shixinzhan".getClass();
        System.out.println(c.toString());
    }

    private static void swarp(Integer a,Integer b) {
        Field field;
        try {
            field=a.getClass().getDeclaredField("value");
            field.setAccessible(true);
            int a1 = new Integer(a);
            field.set(a, b);
            field.set(b, a1);
            field.setAccessible(false);
        } catch (NoSuchFieldException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
