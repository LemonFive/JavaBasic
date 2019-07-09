package com.csh.DesignPattern.SingletonPattern;

/**
 * @desc: 采用volatile + double check 方式避免实例化过程中产生的重排序，会导致NPE
 * @author: CuiShiHao
 **/

public class DCL {

    private static DCL hoonSingleton = null;

    //使用sync 同步DCL.class 两次判断hoonSingleton是否为null 避免并发导致hoonSingleton被重新实例化
    // 锁的粒度变小了，实现了实例对象的唯一性
    public static DCL getInstance(){
        if(hoonSingleton==null){
            synchronized (DCL.class) {
                if(hoonSingleton==null) {
                    hoonSingleton = new DCL();
                }
            }
        }
        return hoonSingleton;
    }

    public static void main(String[]args){
        for(int i=0;i<20;i++){
            Thread thread =new Thread() {
                @Override
                public void run() {
                    DCL hoonSingleton = DCL.getInstance();
                    System.out.println(hoonSingleton);
                }
            };
            thread.start();
        }
    }
}
