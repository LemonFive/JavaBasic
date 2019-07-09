package com.csh.DesignPattern.SingletonPattern;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class EnumSingletonDemo {
    private EnumSingletonDemo(){
    }

    private enum EnumHolder{
        INSTANCE;
        private static  EnumSingletonDemo instance=null;

        private EnumSingletonDemo getInstance(){
            if(instance ==null) {
                instance = new EnumSingletonDemo();
            }
            return instance;
        }
    }

    //实现懒加载
    public static EnumSingletonDemo  getInstance(){
        return EnumHolder.INSTANCE.getInstance();
    }


    public static void main(String[]args){
        for(int i=0;i<20;i++){
            Thread thread =new Thread() {
                @Override
                public void run() {
                    //主动调用的时候采取实例化，从而实现了一个懒加载
                    EnumSingletonDemo enumSingletonDemo = EnumSingletonDemo.getInstance();
                    System.out.println(enumSingletonDemo);
                }
            };
            thread.start();
        }
    }
}

