package com.csh.JVM;

/**
 * @desc: JVM实验demo1 模拟出频繁Young GC的场景
 * 堆内存分配10MB内存空间，
 * 其中新生代是5MB内存空间，其中Eden区占4MB，每个Survivor区占0.5MB，
 * 大对象必须超过10MB才会直接进入老年代，
 * 年轻代使用ParNew垃圾回收器，老年代使用CMS垃圾回收器
 * <p>
 * 相关配置参数：-XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * @author: CuiShiHao
 **/
public class demo1 {
    public static void main(String[] args) {
        byte[] array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = null;

        byte[] array2 = new byte[2 * 1024 * 1024];
    }
}
