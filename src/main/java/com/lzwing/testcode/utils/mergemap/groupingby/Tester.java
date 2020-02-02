package com.lzwing.testcode.utils.mergemap.groupingby;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.util.stream.Collectors.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/10/8
 * Time: 10:07
 */
public class Tester {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        List<String> strings = Lists.newArrayList("a", "bb", "cc", "ddd");

        Map<Integer, List<String>> result = strings.stream()
                .collect(groupingBy(String::length));

        System.out.println(result);
        System.out.println(StringUtils.repeat("-",100));
    }

    private static void test2() {
        List<String> strings = Lists.newArrayList("a", "bb", "cc", "ddd");

        TreeMap<Integer, List<String>> result = strings.stream()
                .collect(groupingBy(String::length, TreeMap::new, toList()));

        System.out.println(result);
        System.out.println(StringUtils.repeat("-",100));
    }

    private static void test3() {

        List<String> strings = Lists.newArrayList("a", "bb", "cc", "ddd");

        Map<Integer, TreeSet<String>> result = strings.stream()
                .collect(groupingBy(String::length, toCollection(TreeSet::new)));

        System.out.println(result);
        System.out.println(StringUtils.repeat("-",100));
    }

    private static void test4() {
        List<String> strings = Lists.newArrayList("a", "bb", "cc", "ddd");

        Map<Integer, Long> result = strings.stream()
                .collect(groupingBy(String::length, counting()));

        System.out.println(result);
        System.out.println(StringUtils.repeat("-",100));

    }

    private static void test5() {
        List<String> strings = Lists.newArrayList("a", "bb", "cc", "ddd");

        Map<Integer, String> result = strings.stream()
                .collect(groupingBy(String::length, joining(",", "[", "]")));

        System.out.println(result);
        System.out.println(StringUtils.repeat("-",100));

    }

    private static void test6() {

        /*List<String> strings = Lists.newArrayList("a", "bb", "cc", "ddd");

        Map<Integer, Double> result = strings.stream()
                .collect(groupingBy(String::length, filtering(s -> !s.contains("c"), toList())));

        System.out.println(result);*/


        List<String> strings = Lists.newArrayList("a", "bb", "cc", "ddd");

        Map<Integer, Double> result = strings.stream()
                .collect(groupingBy(String::length, averagingInt(String::hashCode)));

        System.out.println(result);
    }
}
