package com.lzwing.testcode.java8.streamapi;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/30
 * Time: 19:59
 */
public class MapDemo {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Arrays.asList("a", "b", "c")
                .stream()
                .map(str->str+"bbb")
                .forEach(System.out::println);

        Map collect = Arrays.asList("a", "bb", "ccc")
                .stream()
                .map(Function.identity()) // <- This,
                .map(str -> str)          // <- is the same as this.
                .collect(Collectors.toMap(
                        Function.identity(),
                        new Function<Object, Object>() {
                            @Override
                            public Object apply(Object o) {
                                return o;
                            }
                        }));// <-- is the same as this.

        System.out.println(collect);
    }
}
