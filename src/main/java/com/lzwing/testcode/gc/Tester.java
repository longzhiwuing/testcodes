package com.lzwing.testcode.gc;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/26
 * Time: 10:55
 */
public class Tester {


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            Foo foo = new Foo();
            foo.out();
        }
        System.gc();
//        Thread.currentThread().join();
    }
}
