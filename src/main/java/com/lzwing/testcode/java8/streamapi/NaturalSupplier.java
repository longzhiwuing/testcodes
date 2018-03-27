package com.lzwing.testcode.java8.streamapi;

import java.util.function.Supplier;

class NaturalSupplier implements Supplier<Long> {

    long value = 0;

    public Long get() {
        this.value = this.value + 1;
        return this.value;
    }
}