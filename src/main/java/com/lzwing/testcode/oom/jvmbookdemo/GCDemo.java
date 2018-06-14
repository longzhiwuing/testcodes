package com.lzwing.testcode.oom.jvmbookdemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/10
 * Time: 15:12
 */
public class GCDemo {
    /**
     * jvm:-verbose:gc
     *
     * @param args
     */
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }

        int a = 0;
        System.gc();
    }
}
