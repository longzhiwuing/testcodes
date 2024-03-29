package com.lzwing.testcode.gc;

import java.lang.instrument.Instrumentation;

public class SizeTool {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}