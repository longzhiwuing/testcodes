package com.lzwing.testcode.java8.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/1/28
 * Time: 10:45
 */
public class StreamApiTest {

    public static void main(String[] args) {
//        list();

//        natural();

//        FibonacciStream();
//        PiSupplierTest();
//        studentTest();
//        streamTest();
//        intermediateTest();
//        terminalTest();
        shortCircuitingTest();
    }

    private static void shortCircuitingTest() {
        boolean allMatch = Stream.of(1, 2, 3, 4)
                .allMatch(integer -> integer > 0);
        System.out.println("allMatch: " + allMatch); // 打印结果：allMatch: true

        boolean anyMatch = Stream.of(1, 2, 3, 4)
                .anyMatch(integer -> integer > 3);
        System.out.println("anyMatch: " + anyMatch); // 打印结果：anyMatch: true

        Optional<Integer> any = Stream.of(1, 2, 3, 4).findAny();
        System.out.println(any.get());

        Optional<Integer> anyFirst = Stream.of(1, 2, 3, 4).findFirst();
        System.out.println(anyFirst.get());

        System.out.println("---------------");

        Stream.of(1, 2, 3, 4, 5)
                .limit(2)
                .forEach(System.out::println);

        boolean noneMatch = Stream.of(1, 2, 3, 4, 5)
                .noneMatch(integer -> integer > 10);
        System.out.println("noneMatch:" + noneMatch); // 打印结果 noneMatch:true

        boolean noneMatch_ = Stream.of(1, 2, 3, 4, 5)
                .noneMatch(integer -> integer < 3);
        System.out.println("noneMatch_:" + noneMatch_); // 打印结果 noneMatch_:false
    }

    private static void terminalTest() {
        long count = Stream.of(1, 2, 3, 4, 5)
                .count();
        System.out.printf("count:%d%n", count);// 打印结果：count:5

        Stream.of(5, 2, 1, 4, 3)
                .sorted((o1, o2) -> o2 - o1)
                .forEachOrdered(integer -> {
                    System.out.println("integer:" + integer);
                });

        Optional<Integer> max = Stream.of(5, 4, 3, 2, 1)
                .max((o1, o2) -> o1 - o2);
        System.out.println("max:" + max.get());// 打印结果：max:1
    }

    private static void intermediateTest() {
        Stream.concat(Stream.of(1, 2, 3), Stream.of(5, 6))
                .forEach(i -> System.out.printf("%d|", i));

        System.out.println();

        Stream.of(1, 2, 3, 1, 2, 3)
                .distinct()
                .forEach(System.out::print);

        System.out.println();

        Stream.of(1, 2, 3, 4, 5)
                .filter(i -> i > 3)
                .forEach(System.out::println);
        Stream.of("a", "b")
                .map(itm -> itm.toUpperCase())
                .forEach(System.out::println);

        System.out.println("--------------");

        Stream.of(1, 2, 3, 4, 5)
                .flatMap(itm -> Stream.of(itm * 10))
                .forEach(System.out::print);
        System.out.println();
        System.out.println("---------------");

        Stream.of(1, 2, 3, 4, 5)
                .peek(itm -> {
                    System.out.printf("accept:%d%n", itm *= 10);
                })
                .forEach(System.out::println);
        System.out.println();
        System.out.println("---------------");
        Stream.of(1, 2, 3, 4, 5)
                .skip(2)
                .forEach(System.out::println);
        System.out.println("---------------");

        Stream.of(5, 4, 3, 2, 1)
                .sorted()
                .forEach(System.out::print);

        System.out.println();
        System.out.println("---------------");

        Stream.of(3, 1, 2, 5, 4)
                .sorted((o1, o2) -> o1 - o2)
                .forEach(System.out::print);
        System.out.println();
        System.out.println("---------------");
    }

    private static void streamTest() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<String> stringStream = Stream.of("A");

        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(10).forEach(System.out::println);

        Stream.iterate(100, item -> item + 1)
                .limit(10)
                .forEach(System.out::println);

        int ids[] = new int[]{1, 2, 3, 4};
        Arrays.stream(ids).forEach(System.out::println);
    }

    private static void studentTest() {
        Student stuA = new Student(1, "A", "M", 184,null);
        Student stuB = new Student(2, "B", "G", 163,null);
        Student stuC = new Student(3, "C", "M", 175,null);
        Student stuD = new Student(4, "D", "G", 158,null);
        Student stuE = new Student(5, "E", "M", 170,null);

        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

//        list.stream().filter(student -> student.getSex().equals("G")).forEach(System.out::println);
//        System.out.println(list.stream().filter(stu -> stu.getHeight() > 170).count());
        long count = list.stream().filter(stu -> {
            System.out.println(stu.getName());
            return stu.getNo() > 1;
        }).count();
        System.out.println(count);
    }

    private static void PiSupplierTest() {
        Stream<Double> piStream = Stream.generate(new PiSupplier());
        piStream.skip(100).limit(10)
                .forEach(System.out::println);
    }

    private static void FibonacciStream() {
        Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());
        fibonacci.limit(10).forEach(System.out::println);
        List<Long> list = fibonacci.skip(20).limit(10).collect(Collectors.toList());
    }

    private static void natural() {
        //自然数
        Stream<Long> natural = Stream.generate(new NaturalSupplier());
        natural.map((x) -> {
            return x * x;
        }).limit(10).forEach(System.out::println);
    }


    private static void list() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        stream.filter((x) -> {
            return x % 2 == 0;
        }).map((x) -> {
            return x * x;
        }).forEach(System.out::println);
    }
}
