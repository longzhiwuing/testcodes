package com.lzwing.testcode.gof23.Decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 22:13
 */
public class Tester {
    public static void main(String[] args) {

        //Wrapper wrapper = new TimeChecker(new Logger(new RealService(null)));

        Wrapper wrapper = new Logger(new TimeChecker(new RealService(null)));

        wrapper.doWrap();


    }
}
