package com.lzwing.testcode.owntest;

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/8
 * Time: 11:49
 */
public class ListMapSearchDemo {

    public static void main(String[] args) {
//        testListMapSearch();
//        integerEqualsTest();
        testTryFinally();

    }

    private static void testTryFinally() {
        try {
            tryFinally();
        } catch (Exception e) {
            System.out.println("exception");
        }

        System.out.println("finish");
    }

    private static void tryFinally() {
        try{
            throw new RuntimeException();
        }finally {
            System.out.println("finally");
        }
    }



    private static void integerEqualsTest() {
        /*Integer i = 1;
        int j = 1;*/

        Integer i = 128;
        Integer j = 128;

        System.out.println(i==j);
    }

    private static void testListMapSearch() {
        Integer n = 5000000;
        Integer i = testListSearch(n);
        Map<Integer,Integer> map = generateMap(n);
        testMapSearch(i, map);
    }

    private static Map<Integer,Integer> generateMap(Integer n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i=0;i<n;i++) {
            map.put(i, i);
        }

        return map;
    }

    private static int testListSearch(Integer n) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        Integer i = 0;
        for (i = 0; i < n; i++) {
            if (i == RandomUtils.nextInt(0, n)) {
                break;
            }
        }
        stopwatch.stop();
        System.out.printf("i=%d,time=%d\n", i,stopwatch.getTime());
        return i;
    }

    private static void testMapSearch(int i, Map<Integer, Integer> map) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        Integer integer = map.get(i);
        stopwatch.stop();
        System.out.printf("i=%d,time=%d\n", integer,stopwatch.getTime());
    }
}
