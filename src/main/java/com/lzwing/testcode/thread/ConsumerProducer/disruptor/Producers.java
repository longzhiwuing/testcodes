package com.lzwing.testcode.thread.ConsumerProducer.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class Producers {
    //创建环形队列(环形缓冲区)
    private final RingBuffer<MyData> ringBuffer;

    public Producers(RingBuffer<MyData> ringBuffer) {
        //将ringBuffer与Producers绑定
        this.ringBuffer = ringBuffer;
    }

    //此方法将产生的数据推入缓冲区
    public void putData(ByteBuffer byteBuffer){

        //通过.next()方法得到ringBuffer的下一个节点，并且赋值给sequeue
        long sequeue = ringBuffer.next();

        //将mydata数据存入到下一个节点
        MyData event = ringBuffer.get(sequeue);

        //mydata的值有ByteBuffer参数带入
        event.setValue(byteBuffer.getLong(0));

        //将sequeue节点内的数据发布
        ringBuffer.publish(sequeue);
    }
}