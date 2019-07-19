package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;

import static java.lang.System.out;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class JOLDemo2 {
    public static void main(String[] args) throws InterruptedException {

        A a = new A();

        out.println(ClassLayout.parseInstance(a).toPrintable());

        synchronized (a){
            out.println("同步代码块中");
            out.println(ClassLayout.parseInstance(a).toPrintable());
        }

        out.println("after synchronized");
        out.println(ClassLayout.parseInstance(a).toPrintable());

    }
}
