package com.lzwing.testcode.java8.streamapi;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/1/29
 * Time: 8:35
 */
public class FunctionComsumerPredicateTest {
    public static void main(String[] args) throws InterruptedException {
        functionTest();
    }

    private static void functionTest() {
        String name = "";
        String name1 = "12345";
        String name2 = "12";
//        System.out.println(validInput4Func(name, inputStr -> inputStr.isEmpty() ? "名字不能为空" : inputStr));
//        System.out.println(validInput4Func(name1, inputStr -> inputStr.length() > 3 ? "名字过长" : inputStr));
//        validInput4Consumer(name, inputStr ->
//                System.out.println(inputStr.isEmpty() ? "名字不能为空":"名字正常"));
//        validInput4Consumer(name1, inputStr ->
//                System.out.println(inputStr.isEmpty() ? "名字不能为空":"名字正常"));
        System.out.println(validInput4Predicate(name, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));
        System.out.println(validInput4Predicate(name1, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));
        System.out.println(validInput4Predicate(name2, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));


    }

    public static String validInput4Func(String name, Function<String, String> function) {
        return function.apply(name);
    }

    public static void validInput4Consumer(String name, Consumer<String> function) {
        function.accept(name);
    }

    public static boolean validInput4Predicate(String name, Predicate<String> function) {
        return function.test(name);
    }
}
