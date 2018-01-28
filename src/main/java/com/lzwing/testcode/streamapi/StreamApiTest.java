package com.lzwing.testcode.streamapi;

import java.util.Arrays;
import java.util.List;
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
        PiSupplierTest();
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
