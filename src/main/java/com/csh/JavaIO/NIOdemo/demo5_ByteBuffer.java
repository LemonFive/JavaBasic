package com.csh.JavaIO.NIOdemo;

import java.nio.ByteBuffer;

/**
 * @description  按顺序读取ByteBuffer中可以放其他类型
 * @author  CuiShiHao
 * @return
 */
public class demo5_ByteBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(100);
        buffer.putChar('a');
        buffer.putInt(2);
        buffer.putLong(50000L);
        buffer.putShort((short) 2);
        buffer.putDouble(12.4);
        System.out.println(buffer.position());
        buffer.flip();
        System.out.println(buffer.getChar());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getDouble());
    }
}
