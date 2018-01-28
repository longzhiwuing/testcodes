package com.lzwing.testcode.streamapi;

import java.util.function.Supplier;

class PiSupplier implements Supplier<Double> {

    double sum = 0.0;
    double current = 1.0;
    boolean sign = true;

    @Override
    public Double get() {
        sum += (sign ? 4 : -4) / this.current;
        this.current = this.current + 2.0;
        this.sign = ! this.sign;
        return sum;
    }
}