package com.csh.JavaIO.NIOdemo;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description NIO中channel 读操作
 * @author  CuiShiHao
 * @date    2019/8/19
 *
 * Java NIO的通道类似流，但又有些不同：
 *
 * 既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
 * 通道可以异步地读写。
 * 通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。
 *
 */
public class demo2_channelRead {
    public static void main(String[] args) throws Exception {
        // 文件操作可以由IO升级为NIO
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\89509\\Desktop\\demo2.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.remaining()>0){
            System.out.println((char)byteBuffer.get());
        }
        fileInputStream.close();
    }
}
