package com.csh.Concurrent.JOLDemo;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class JOLTest {

    static A a = new A();
    public static void main(String[] args) {

        out.println(VM.current().details());

        out.println("a的HashCode---------");
        out.println("0x"+Integer.toHexString(a.hashCode()));
        out.println("---------");

        out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
