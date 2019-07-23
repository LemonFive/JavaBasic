package com.csh.basic;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @desc:   SystemOut输出数据重定向
 * @author: CuiShiHao
 **/
public class ChangeOut {
    public static void main(String args[]) {

        String str1 = "A";
        String str2 = "BC";
        String str3 = "ABC";
        String str4 = "ABC";
        String str5 = "A" + "BC";
        String combo = str1 + str2;
        System.out.println(str3 == combo);
        System.out.println(str3 == str5);
        System.out.println(str5 == combo);

        try {
            System.setOut(new PrintStream(new FileOutputStream("logout.txt1111")));
            System.out.println("Now the output is redirected!");
        } catch(Exception e) {}

        double data = 12312.0;
        System.out.println(100);
        System.out.println(data);
        System.out.println('c');
        System.out.println(true);
        System.out.println(new Object());

        char[] charset = new char[100];
        System.out.println(charset);
    }
}
