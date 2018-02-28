package com.lzwing.testcode.java8;

import com.lzwing.testcode.guava.User;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/2/26
 * Time: 16:06
 */
public class OptionalTest {
    public static void main(String[] args) {
//        t1();

        System.out.println(t2(Optional.empty()));
        System.out.println(t2(Optional.of(new User("newUser"))));


    }

    private static void t1() {
        //filter方法检查给定的Option值是否满足某些条件。
        //如果满足则返回同一个Option实例，否则返回空Optional。
        Optional<Integer> age = Optional.of(20);
        Optional<Integer> oldAge = age.filter(a -> a > 18);
        Optional<Integer> lessAge = age.filter(a -> a < 18);
        // 打印结果：Optional[20]
        System.out.println(oldAge);
        System.out.println(oldAge.get());
        // 打印结果：Optional.empty
        System.out.println(lessAge);
        System.out.println(lessAge.get());
    }

    public static int t2(Optional<User> user) {
        System.out.println(user.orElse(new User("defaultUser")));
        user.ifPresent(System.out::println);
        return user.map(u -> u.getAge()).orElse(-100);
    }
}
