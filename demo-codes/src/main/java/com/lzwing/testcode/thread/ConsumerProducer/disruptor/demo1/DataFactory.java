package com.lzwing.testcode.thread.ConsumerProducer.disruptor.demo1;

import com.lmax.disruptor.EventFactory;

public class DataFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new MyData();
    }
}