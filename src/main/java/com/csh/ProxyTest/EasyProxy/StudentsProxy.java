package com.csh.ProxyTest.EasyProxy;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class StudentsProxy implements Person{
    //被代理的学生
    Student stu;
    public StudentsProxy(Person stu) {
        // 只代理学生对象
        if(stu.getClass() == Student.class) {
            this.stu = (Student)stu;
        }
    }

    //代理上交班费，调用被代理学生的上交班费行为
    @Override
    public void giveMoney() {
        System.out.println("张三最近学习有进步！");
        stu.giveMoney();
    }
}
