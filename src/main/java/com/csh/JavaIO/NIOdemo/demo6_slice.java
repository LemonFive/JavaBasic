package com.csh.JavaIO.NIOdemo;

import java.nio.ByteBuffer;

public class demo6_slice {
    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        for(int i=0;i<byteBuffer.capacity();++i){
            byteBuffer.put((byte)i);
        }
        byteBuffer.position(2);
        byteBuffer.limit(8);

        // 创建新的字节缓冲区，其内容是缓冲区内容的共享
        ByteBuffer resetBuffer = byteBuffer.slice();
        // resetBuffer修改数据后 byteBuffer也会修改
        for(int i=0;i<resetBuffer.capacity();i++){
            byte anInt = resetBuffer.get();
            resetBuffer.put(i, (byte) (anInt*2));
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }

    }
}
