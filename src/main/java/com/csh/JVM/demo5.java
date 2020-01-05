package com.csh.JVM;

/**
 * @desc: 如何定位和解决频繁Full GC问题？ demo5练习
 * @author: CuiShiHao
 * 新生代我们通过“-XX:NewSize”设置为100MB了
 * 然后其中Eden区是80MB，每个Survivor区是10MB，
 * Java堆总大小是200MB，老年代是100MB
 * 但是我们通过“-XX:MaxTenuringThreshold=15”设置了，只要对象年龄达到15岁才会直接进入老年代。
 * 大对象阈值为3MB，也就是超过3MB，就直接进入老年代
 * <p>
 * 配置参数: -XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=20971520 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 **/
public class demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true) {
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 4; i++) {
            data = new byte[10 * 1024 * 1024];
        }
        data = null;

        byte[] data1 = new byte[10 * 1024 * 1024];
        byte[] data2 = new byte[10 * 1024 * 1024];
        byte[] data3 = new byte[10 * 1024 * 1024];
        data3 = new byte[10 * 1024 * 1024];

        Thread.sleep(1000);
    }
}
