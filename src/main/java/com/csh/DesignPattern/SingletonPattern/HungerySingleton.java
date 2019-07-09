package com.csh.DesignPattern.SingletonPattern;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class HungerySingleton {

    //ClassLoader 加载时阐释实例对象，只有这一次，线程安全的
    private static HungerySingleton hungerySingleton = new HungerySingleton();

    public static HungerySingleton getInstance(){
        return hungerySingleton;
    }

    public static void main(String[]args){
        for(int i=0;i<20;i++){
            Thread thread =new Thread() {
                @Override
                public void run() {
                    HungerySingleton hungerySingleton = HungerySingleton.getInstance();
                    System.out.println(hungerySingleton);
                }
            };
            thread.start();
        }
    }


}

