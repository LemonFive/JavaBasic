package com.csh.JavaIO.NIOdemo;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description  channel写操作
 * @author  CuiShiHao
 * @date    2019/8/20
 */
public class demo3_channelWrite {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream=new FileOutputStream("dome3.txt");
        FileChannel channel = fileOutputStream.getChannel();
        byte[] bytes="taibai".getBytes();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
