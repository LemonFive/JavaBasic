package com.csh.DesignPattern.SingletonPattern;

/**
 * @desc:
 * @author: CuiShiHao
 **/
public class HoonSingleton {
    //不能保證實例對象的唯一性
    private static HoonSingleton hoonSingleton = null;

    public static HoonSingleton getInstance(){
        if(hoonSingleton==null){
            hoonSingleton = new HoonSingleton();
        }
        return hoonSingleton;
    }

    public static void main(String[]args){
        for(int i=0;i<20;i++){
            Thread thread =new Thread() {
                @Override
                public void run() {
                    HoonSingleton hoonSingleton = HoonSingleton.getInstance();
                    System.out.println(hoonSingleton);
                }
            };
            thread.start();
        }
    }
}
