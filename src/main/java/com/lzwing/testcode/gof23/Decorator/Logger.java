package com.lzwing.testcode.gof23.Decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 22:11
 */
public class Logger implements Wrapper {

    Wrapper wrapper;

    Logger(Wrapper wrapper) {
        this.wrapper=wrapper;
    }

    @Override
    public void doWrap() {
        System.out.println("before logging....");
        if (this.wrapper != null) {
            this.wrapper.doWrap();
        }
        System.out.println("after logging....");

    }
}
