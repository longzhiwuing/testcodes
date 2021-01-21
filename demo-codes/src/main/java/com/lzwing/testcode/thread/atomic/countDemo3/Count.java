package com.lzwing.testcode.thread.atomic.countDemo3;

public class Count {
    private int num;

    public void incrementAndGet() {
        num++;
    }

    public int get() {
        return num;
    }
}  