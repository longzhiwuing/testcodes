package com.lzwing.testcode.thread.ConsumerProducer.disruptor.demo2;

public class DataEvent {
    private long value;

    public void set(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
