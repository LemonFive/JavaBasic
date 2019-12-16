package com.csh.basic.lombokTest;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class MainTest {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.setId("1");
        //cat.setName("test");

        Animal dog = new Dog();
        dog.setId("1");
        //dog.setName("test");

        System.out.println(dog.equals(cat));
    }
}
