package com.lzwing.testcode.classloader;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/12/6
 * Time: 20:22
 */
public class Tester {
    public static void main(String[] args) throws Exception{
        Class<?> x = Class.forName("[[C");
        System.out.println(x);

        x = ClassLoader.getSystemClassLoader().loadClass("com.lzwing.testcode.classloader.Tester");
        System.out.println(x);
    }
}
