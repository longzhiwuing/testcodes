package com.lzwing.testcode.gist.innerclass4java8;

public class ClassOuter {

    Object object = new Object() {
        public void finalize() {
            System.out.println("inner Free the occupied memory...");
        }
    };

    public void finalize() {
        System.out.println("Outer Free the occupied memory...");
    }
}