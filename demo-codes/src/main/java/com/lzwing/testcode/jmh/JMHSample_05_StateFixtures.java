package com.lzwing.testcode.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class JMHSample_05_StateFixtures {
    double x;

    @Setup
    public void prepare() {
        x = Math.PI;
    }

    @TearDown
    public void check() {
        assert x > Math.PI : "Nothing changed?";
    }

    @Benchmark
    public void measureRight() {
        x++;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_05_StateFixtures.class.getSimpleName())
                .forks(1)
                .jvmArgs("-ea")
                .build();

        new Runner(opt).run();
    }
}