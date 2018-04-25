package com.lzwing.testcode.gof23.Decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 22:00
 */
public class TimeChecker implements Wrapper {

    Wrapper wrapper;

    TimeChecker(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void doWrap() {
        long start = System.currentTimeMillis();
        System.out.println("start checkTime...");
        if (this.wrapper != null) {
            this.wrapper.doWrap();
        }
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }
}
