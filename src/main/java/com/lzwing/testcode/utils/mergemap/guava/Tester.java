package com.lzwing.testcode.utils.mergemap.guava;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.lzwing.testcode.guava.Person;
import com.lzwing.testcode.guava.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/2/2
 * Time: 14:45
 */
@SuppressWarnings("Duplicates")
public class Tester {
    public static void main(String[] args) {

//        testMultiMap();
        testMultiCollection();
    }


    private static void testMultiMap() {
        //1.1 转化后具有唯一Key
        List<Person> persons = Arrays.asList(
                new Person("zhang", 15),
                new Person("wang", 16),
                new Person("lee", 18)
        );
        /**
         * 转换后的Map具有唯一键
         */
        Map<String, Person> map = Maps.uniqueIndex(persons, new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        });

        System.out.println("map = " + map);

        //1.2 转化后的Key不唯一
        persons = Lists.newArrayList(
                new Person("zhang", 15),
                new Person("zhang", 16),
                new Person("lee", 18)
        );
        /**
         * 转换后的Map有重复键
         */
        Multimap<String, Person> multiMap = Multimaps.index(persons, new Function<Person, String>() {
            public String apply(Person person) {
                return person.getName();
            }
        });

        System.out.println("multiMap = " + multiMap);

    }

    public static void testMultiCollection() {
        Multimap<String, User> scoreMultimap = ArrayListMultimap.create();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("user" + i);
            user.setAge(i);
            user.setMale(i % 2 == 0);
            scoreMultimap.put("0user", user);
        }
        for (int i = 10; i < 15; i++) {
            User user = new User();
            user.setName("user" + i);
            user.setAge(i);
            user.setMale(i % 2 == 0);
            scoreMultimap.put("10user", user);
        }

        Collection<User> values = scoreMultimap.values();

        System.out.println(values);

        Collection<User> collection = scoreMultimap.asMap().get("10user");

        System.out.println(collection);

    }
}
