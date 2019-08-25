package com.csh.JavaIO.NIOdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description  channel读写操作
 * @author  CuiShiHao
 * @date    2019/8/20
 */
public class demo4_channelReanAndWrite {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream=new FileOutputStream("demo4write.txt");
        FileInputStream fileInputStream=new FileInputStream("demo4read.txt");

        FileChannel channelRead = fileInputStream.getChannel();
        FileChannel channelWrite = fileOutputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(5);
       while (true){
           byteBuffer.clear();
           System.out.println(byteBuffer.position());
           int readNumber = channelRead.read(byteBuffer);
           System.out.println(readNumber);
           if(-1==readNumber){
               break;
           }
           //byteBuffer.flip();
           channelWrite.write(byteBuffer);
       }
       fileOutputStream.close();
       fileInputStream.close();
    }
}
