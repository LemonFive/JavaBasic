package com.csh.JavaIO.NIOdemo;

import java.nio.ByteBuffer;

public class demo9_wrap {
    public static void main(String[] args) throws Exception {
        byte[] bytes=new byte[]{'a','b','c'};

        // 使用warp方法创建的Buffer需要保证原生的bytes不能被修改
        ByteBuffer byteBuffer=ByteBuffer.wrap(bytes);
        bytes[0]='b';
        byteBuffer.put(2,(byte)'b');
        for(int i=0;i<byteBuffer.capacity();i++){
            System.out.println((char)byteBuffer.get());
        }
    }
}
