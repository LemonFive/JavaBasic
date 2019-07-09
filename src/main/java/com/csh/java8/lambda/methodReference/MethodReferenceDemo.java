package com.csh.java8.lambda.methodReference;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @desc:  方法引用
 * @author: CuiShiHao
 **/
public class MethodReferenceDemo {
    private Student stu1 = new Student("zhangsan",75);
    private Student stu2 = new Student("lisi",79);
    private Student stu3 = new Student("wangwu",85);
    private Student stu4 = new Student("zhaoliu",59);

    public static void main(String[] args) {
        List<String> list= Arrays.asList("hello","world","helloWorld");

        list.forEach(item -> System.out.println(item));

        list.forEach(System.out::println);
    }

    /**
    * @description  方法引用示例1   类名::静态方法名
    * @author  CuiShiHao
    * @date    2019/5/19
    */
    @Test
    public void test1(){

        List<Student> list = Arrays.asList(stu1,stu2,stu3,stu4);

//        list.sort((student1,student2)->
//                Student.compareStudentByScore(student1,student2));
//
//        list.forEach(item -> System.out.println(item.getName()));

        list.sort(Student::compareStudentByScore);

        list.forEach(item -> System.out.println(item.getName()));
    }


    /**
    * @description  方法引用示例2   引用名(对象名)::实例方法名
    * @author  CuiShiHao
    * @date    2019/5/19
    */
    @Test
    public void test2(){
        List<Student> list = Arrays.asList(stu1,stu2,stu3,stu4);

        StudentComparator studentComparator = new StudentComparator();
        list.sort(studentComparator::compareStudentByName);
        list.forEach(item -> System.out.println(item.getName()));
    }


    /**
    * @description  方法引用示例3 类名::实例方法名
    * @author  CuiShiHao
    * @date    2019/5/19
    */
    @Test
    public void test3(){
        List<Student> list = Arrays.asList(stu1,stu2,stu3,stu4);
        list.sort(Student::compareByName);
        list.forEach(item -> System.out.println(item.getName()));

        List<String> cities = Arrays.asList("shanghai","tianjin","guangzhou","beijing");

        //Collections.sort(cities,(city1,city2)->city1.compareTo(city2));
        Collections.sort(cities,String ::compareTo);
        cities.forEach(System.out::println);
    }


    public String getString(Supplier supplier){
        return supplier.get() +"test";
    }

    public String getString2(String str, Function<String ,String> function){
        return function.apply(str);
    }
    /**
    * @description  方法引用示例3构造方法引用  类名::new
    * @author  CuiShiHao
    * @date    2019/5/19
    */
    @Test
    public void test4(){
        MethodReferenceDemo demo = new MethodReferenceDemo();
        System.out.println(demo.getString(String::new));

        System.out.println(demo.getString2("hello",String::new));
    }
}
