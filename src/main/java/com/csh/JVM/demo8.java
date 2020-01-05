package com.csh.JVM;

/**
 * @desc: 模拟JVM 栈内存溢出
 * <p>
 * 参数如下：-XX:ThreadStackSize=1m
 * 通过这个参数设置JVM的栈内存为1MB。
 * @author: CuiShiHao
 **/
public class demo8 {

    public static long counter = 0;

    public static void main(String[] args) {
        work();
    }

    public static void work() {
        System.out.println("目前为第" + (++counter) + "次，执行worker方法");
        work();
    }
}
