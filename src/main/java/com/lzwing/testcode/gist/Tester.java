package com.lzwing.testcode.gist;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/11
 * Time: 17:24
 */
public class Tester {
    public static void main(String[] args) {
//        listDemos();
        testMaxMin();
    }

    private static void testMaxMin() {
        System.out.println(Math.max(1, 10));
        System.out.println(Math.min(1, 10));
    }

    /**
     * guava 方便声明、foreach lambda实现
     */
    private static void listDemos() {
        List<String> list = Lists.newArrayList("aa","bb","cc");

        list.forEach(s->{
            System.out.println("s = " + s);
            System.out.println(new Date());
        });
    }
}
