package com.lzwing.testcode.java8;

import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;

public class ParallelStream {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        LongAdder sum = new LongAdder();
        list.parallelStream().forEach(integer -> {
//            System.out.println("当前线程" + Thread.currentThread().getName());
            sum.add(integer);
        });
        System.out.println(sum);
    }
}