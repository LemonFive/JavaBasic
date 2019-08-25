package com.csh.JavaIO.NIOdemo;

import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @description  以IntBuffer为例简单说明buffer
 * @author  CuiShiHao
 * @date    2019/8/19
 * capacity：在读/写模式下都是固定的，就是我们分配的缓冲大小（容量）。
 * position：类似于读/写指针，表示当前读(写)到什么位置。
 *   limit：在写模式下表示最多能写入多少数据，此时和capacity相同。
 *           在读模式下表示最多能读多少数据，此时和缓存中的实际数据大小相同。
 *
 *
 *           CharBuffer.allocate(48);         创建HeapByteBuffer 堆内创建，数据在JVM中，底层为byte[]
 *           ByteBuffer.allocateDirect(100);  创建DirectByteBuffer 堆外创建  对象在JVM中，引用
 *           DirectByteBuffer里维护了一个引用address指向了数据，从而操作数据
 *
 *           HeapByteBuffer优点：由于内容维护在jvm里，所以把内容写进buffer里速度会快些；并且，可以更容易回收
 *           DirectByteBuffer优点：跟外设（IO设备）打交道时会快很多，因为外设读取jvm堆里的数据时，不是直接读取的，而是把jvm里的数据读到一个内存块里，再在这个块里读取的，如果使用DirectByteBuffer，则可以省去这一步，实现zero copy（零拷贝）
 *
 *          外设之所以要把jvm堆里的数据copy出来再操作，不是因为操作系统不能直接操作jvm内存，而是因为jvm在进行gc（垃圾回收）时，会对数据进行移动，一旦出现这种问题，外设就会出现数据错乱的情况
 *
 */
public class demo1_buffer {
    public static void main(String[] args) {
//        IntBuffer buffer = IntBuffer.allocate(8);
//        for (int i=0;i<buffer.capacity();i++){
//            int nextInt = new SecureRandom().nextInt(20);
//            buffer.put(nextInt);
//        }
//        //buffer.flip();
//
//        while (buffer.hasRemaining()){
//            System.out.println(buffer.get());
//        }

        CharBuffer buf = CharBuffer.allocate(48);
        buf.put(new char[] {'a', 'b', 'c', 'd', 'e'});
        buf.flip();
        System.out.println(buf.get());
        buf.clear();
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        buf.put('g');
        buf.flip();
        System.out.println(buf.get());
        System.out.println(buf.get());

    }
}
