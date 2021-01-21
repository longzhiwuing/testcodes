package com.lzwing.testcode.oom;

public class ReferenceDemo {

    public Object instance = null;

    private static final int _1Mb = 1024 * 1024;

    private byte [] bigSize = new byte [ 10 * _1Mb];

    public static void main(String[] args) {
        System.out.println(String.format("开始 %d M", Runtime.getRuntime().freeMemory() / (1024 * 1024)));

        ReferenceDemo referenceDemo = new ReferenceDemo();
        ReferenceDemo referenceDemo2 = new ReferenceDemo();
        referenceDemo.instance = referenceDemo2;
        referenceDemo2.instance = referenceDemo;


        System.out.println(String.format("运行 %d M", Runtime.getRuntime().freeMemory() / (1024 * 1024)));

        referenceDemo = null;
        referenceDemo2 = null;
        System.gc();
        System.out.println(String.format("结束 %d M", Runtime.getRuntime().freeMemory() / (1024 * 1024)));
    }
}