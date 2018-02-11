package com.lzwing.testcode.java8;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/2/8
 * Time: 11:16
 */
public class CounterTest {
    public static void main(String[] args) {
        String[] arr = {"program", "creek", "program", "creek", "java", "web", "program"};
//        Stream<String> stream = Stream.of(arr).parallel();
        Stream<String> stream = Stream.of(arr);
        Map<String, Long> counter = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println(counter);
        System.out.println(counter.get("creek"));
    }
}
