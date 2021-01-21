package com.lzwing.testcode.java8.streamapi;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/1/29
 * Time: 15:34
 */
public class CollectorTest {
    public static void main(String[] args) {
//        listTest();
//        setTest();
//        maxByTest();
//        partitionTest();
//        groupByTest();
//        joiningTest();
//        countTest();
//        reduceTest();
//        compareTest();
        testMapAndFlatMap();
    }

    public static void testMapAndFlatMap() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<String> stringList = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(e -> System.out.println(e));
    }

    private static void compareTest() {
        List<Student> list = Lists.newArrayList(
                new Student(1,"a","m",2),
                new Student(1,"b","f",1),
                new Student(1,"c","m",3)
        );

        list = list.stream()
                .sorted(Comparator.comparingInt(student->(int) student.getHeight()))
                .collect(toList());
        System.out.println(list);
    }

    private static void reduceTest() {
        Optional accResult = Stream.of(1, 2, 3, 4)
                .reduce((acc, item) -> {
                    System.out.println("acc : " + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult.get());
        System.out.println("--------");
    }

    private static void countTest() {
        Map<Boolean, Long> partiCount = Stream.of(1, 2, 3, 4)
                .collect(Collectors.partitioningBy(it -> it > 3,
                        Collectors.counting()));
        System.out.println("partiCount: " + partiCount);
    }

    private static void joiningTest() {
        String strJoin = Stream.of("1", "2", "3", "4")
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println("strJoin: " + strJoin);
    }

    private static void groupByTest() {
        Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4)
                .collect(Collectors.groupingBy(it -> it > 3));
        System.out.println("collectGroup : " + collectGroup);
    }

    private static void partitionTest() {
        Map<Boolean, List<Integer>> collectParti = Stream.of(1, 2, 3, 4)
                .collect(Collectors.partitioningBy(it -> it % 2 == 0));
        System.out.println("collectParti : " + collectParti);
    }

    private static void maxByTest() {
        Optional<Integer> collectMaxBy = Stream.of(1, 2, 3, 4)
                .collect(Collectors.maxBy(Comparator.comparingInt(o -> o)));
        System.out.println("collectMaxBy:" + collectMaxBy.get());
    }

    private static void setTest() {
        Set<Integer> collectSet = Stream.of(1, 2, 3, 4, 3, 1, 5)
                .collect(Collectors.toSet());
        System.out.println("collectSet: " + collectSet);
    }

    private static void listTest() {
        List<Integer> collectList = Stream.of(1, 2, 3, 4, 3, 1, 5)
                .collect(toList());
        System.out.println("collectList: " + collectList);
    }
}
