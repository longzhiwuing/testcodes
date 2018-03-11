package com.lzwing.testcode.oom;

import java.util.HashMap;

public class TestLock {

    private HashMap map = new HashMap();

    public TestLock() {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 500000000; i++) {
                    map.put(new Integer(i), i);
                }
                System.out.println("t1 over");
            }
        };

        /*Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 500000000; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t2 over");
            }
        };*/


        t1.start();
//        t2.start();

    }


    public static void main(String[] args) {
        new TestLock();
    }
}