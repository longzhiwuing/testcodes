package com.lzwing.testcode.thread.ConsumerProducer.disruptor;

import com.lmax.disruptor.EventFactory;

public class DataFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new MyData();
    }
}