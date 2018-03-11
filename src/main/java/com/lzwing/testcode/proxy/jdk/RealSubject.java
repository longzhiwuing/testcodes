package com.lzwing.testcode.proxy.jdk;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/11
 * Time: 11:42
 */
public class RealSubject implements Subject {
    @Override
    public Object request() {
        System.out.println("real subject invoked...");
        return "realSubject......";
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
