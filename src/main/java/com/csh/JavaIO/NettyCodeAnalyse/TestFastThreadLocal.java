package com.csh.JavaIO.NettyCodeAnalyse;

import io.netty.util.concurrent.FastThreadLocal;

/**
 * @desc: FastThreadLocal源码分析
 * @author: CuiShiHao
 **/
public class TestFastThreadLocal {
    private static FastThreadLocal<Object> threadLocal =
            new FastThreadLocal<Object>(){
        @Override
        protected Object initialValue(){
            return new Object();
        }
    };

    private static Object object = new Object();

    public static void main(String[] args) {
        new Thread(() ->{
            Object object = threadLocal.get();
            // ...do with object
            System.out.println(object);

            threadLocal.set(new Object());
        }).start();

        new Thread(() ->{
            Object object = threadLocal.get();
            // ...do with object
            System.out.println(object);
        }).start();
    }
}
