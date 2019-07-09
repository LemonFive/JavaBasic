package com.csh.DesignPattern.SingletonPattern;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class HoonSyncSingleton {

    private static HoonSyncSingleton hoonSingleton = null;

    //不能保證實例對象的唯一性 懒汉式 + sync 实现线程安全 因为使用sync导致性能差  退化到了串行执行
    public static synchronized HoonSyncSingleton getInstance(){
        if(hoonSingleton==null){
            hoonSingleton = new HoonSyncSingleton();
        }
        return hoonSingleton;
    }

    public static void main(String[]args){
        for(int i=0;i<20;i++){
            Thread thread =new Thread() {
                @Override
                public void run() {
                    HoonSyncSingleton hoonSingleton = HoonSyncSingleton.getInstance();
                    System.out.println(hoonSingleton);
                }
            };
            thread.start();
        }
    }
}
