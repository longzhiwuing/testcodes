package com.lzwing.testcode.owntest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/9
 * Time: 16:32
 */
public class StaticTester {
    static {
        i = 0;
        
        //illegal
        //System.out.println(i);
    }

    static int i=0;

    static {
        System.out.println(i);
    }
}
