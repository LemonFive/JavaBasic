package com.csh.java8.lambda.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class PersonTest {

    public static void main(String[] args){
        Person person1=new Person("zhangsan",20);
        Person person2=new Person("lisi",40);
        Person person3=new Person("wangwu",30);

        List<Person> personList = Arrays.asList(person1,person2,person3);

        PersonTest test = new PersonTest();
        List<Person> getPersonsList = test.getPersonsByUsername("lisi",personList);

        getPersonsList.forEach(person -> System.out.println(person.getName()));


        List<Person> getPersonsList2 = test.getPersonsByAge(22,personList);
        getPersonsList2.forEach(person -> System.out.println(person.getName()));

        List<Person> getPersonsList3 = test.getPersonsByAge2(22,personList);
        getPersonsList3.forEach(person -> System.out.println(person.getName()));
    }

    List<Person> getPersonsByUsername(String username,List<Person> personList){
        return personList.stream().filter(person -> person.getName().equals(username)).collect(Collectors.toList());
    }

    List<Person> getPersonsByAge(int age,List<Person> personList){
        return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
    }

    List<Person> getPersonsByAge2(int age,List<Person> personList){
        BiFunction<Integer,List<Person>,List<Person>> function = (userAge,persons) ->  {
            return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        };
        return function.apply(age,personList);
    }
}
