package com.lzwing.testcode.java8;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/2/8
 * Time: 11:24
 */
public class ParallelTest {
    public static void main(String[] args) {
         parallelDemo();
    }

    private static void parallelDemo() {
        Stream<Integer> stream = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
//        stream.parallel().forEach(System.out::println);
        stream.parallel().forEachOrdered(System.out::print);
    }
}
