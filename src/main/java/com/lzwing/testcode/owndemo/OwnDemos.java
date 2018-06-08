package com.lzwing.testcode.owndemo;

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
public class OwnDemos {

    public static void main(String[] args) {
        Integer n = Integer.MAX_VALUE;
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
