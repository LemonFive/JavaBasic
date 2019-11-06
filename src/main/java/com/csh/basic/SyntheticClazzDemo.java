package com.csh.basic;

/**
 * @desc:  合成类Demo
 * @author: CuiShiHao
 **/
public class SyntheticClazzDemo {
    private static class Inner {
    }

    static void checkSynthetic (String name) {
        try {
            System.out.println (name + " : " + Class.forName (name).isSynthetic ());
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace (System.out);
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Inner ();
        checkSynthetic ("com.csh.basic.SyntheticClazzDemo");
        checkSynthetic ("com.csh.basic.SyntheticClazzDemo$Inner");
        checkSynthetic ("com.csh.basic.SyntheticClazzDemo$1");
    }

}
