package com.csh.JVM;

/**
 * @desc: Full GC日志
 * @author: CuiShiHao
 * 新生代我们通过“-XX:NewSize”设置为10MB了
 * 然后其中Eden区是8MB，每个Survivor区是1MB，
 * Java堆总大小是20MB，老年代是10MB
 * 但是我们通过“-XX:MaxTenuringThreshold=15”设置了，只要对象年龄达到15岁才会直接进入老年代。
 * 大对象阈值为3MB，也就是超过3MB，就直接进入老年代
 * <p>
 * 配置参数：-XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 **/
public class demo3 {
    public static void main(String[] args) {
        byte[] array1 = new byte[4 * 1024 * 1024];
        array1 = null;

        byte[] array2 = new byte[2 * 1024 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];
        byte[] array4 = new byte[2 * 1024 * 1024];
        byte[] array5 = new byte[128 * 1024];
        byte[] array6 = new byte[2 * 1024 * 1024];
    }
}
