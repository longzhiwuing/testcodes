package com.lzwing.testcode.nio;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static void main( String args[] ) throws Exception {
        fileInputStreamDemo();

        System.out.println();
        System.out.println(StringUtils.repeat("-",50));
        System.out.println();

        RandomAccessFileDemo();
    }

    private static void RandomAccessFileDemo() throws Exception {
        RandomAccessFile file = new RandomAccessFile
                ("d:\\mysql-slow.log","rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);

        buffer.flip();
        byte[] res = new byte[1024];
        buffer.get(res,0,buffer.limit());
        System.out.println(new String(res));

        channel.close();
    }

    private static void fileInputStreamDemo() throws IOException {
        FileInputStream fin = new FileInputStream("d:\\mysql-slow.log");
        // 获取通道  
        FileChannel fc = fin.getChannel();
        // 创建缓冲区  
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 读取数据到缓冲区  
        fc.read(buffer);
        buffer.flip();
        while (buffer.remaining()>0) {  
            byte b = buffer.get();  
            System.out.print(((char)b));  
        }
        fc.close();
        fin.close();
    }
}  