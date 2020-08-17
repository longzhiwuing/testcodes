package com.lzwing.testcode.javafaker;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * <dependency>
 *     <groupId>com.github.javafaker</groupId>
 *     <artifactId>javafaker</artifactId>
 *     <version>1.0.2</version>
 * </dependency>
 *
 *
 * java faker 例子
 *
 * @author: chenzhongyong
 * Date: 2020/8/17
 * Time: 17:31
 */
public class Tester {

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.CHINA);
        // 卢街62号
        System.out.println(faker.address().streetAddress());
        // 胡昊强
        System.out.println(faker.name().fullName());
        // By Grand Central Station I Sat Down and Wept
        System.out.println(faker.book().title());
        // 15128552972
        System.out.println(faker.phoneNumber().cellPhone());
        // Bytecard
        System.out.println(faker.app().name());
        // pink
        System.out.println(faker.color().name());
        // Fri Jan 29 16:04:50 CST 1960
        System.out.println(faker.date().birthday());
        // 000-63-7175
        System.out.println(faker.idNumber().invalid());
    }
}
