package com.lzwing.testcode.gof23.Decorator;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 22:12
 */
public class RealService implements Wrapper {

    Wrapper wrapper;

    RealService(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void doWrap() {
        if (this.wrapper != null) {
            this.wrapper.doWrap();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do work....");
    }
}
