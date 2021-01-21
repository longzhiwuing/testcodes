package com.lzwing.testcode.thread.ConsumerProducer.disruptor.demo2;

import com.lmax.disruptor.EventFactory;

public class DataEventFactory implements EventFactory<DataEvent> {

    @Override
    public DataEvent newInstance() {
        return new DataEvent();
    }
}
