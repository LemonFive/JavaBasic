package com.csh.DesignPattern.SingletonPattern;

/**
 * @desc:
 * @author: CuiShiHao
 **/
//和饿汉模式没有本质区别，采用Enum实现的更巧妙了
public enum EnumSingleton {
    //枚举类型，在加载的时候实例化。
    INSTANCE;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[]args){
        for(int i=0;i<20;i++){
            Thread thread =new Thread() {
                @Override
                public void run() {
                    EnumSingleton enumSingleton = EnumSingleton.getInstance();
                    System.out.println(enumSingleton.getClass().getName());
                    System.out.println(enumSingleton);
                }
            };
            thread.start();
        }
    }
}
