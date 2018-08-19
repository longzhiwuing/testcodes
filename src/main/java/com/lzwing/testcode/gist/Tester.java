package com.lzwing.testcode.gist;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/11
 * Time: 17:24
 */
public class Tester {
    public static void main(String[] args) {
//        listDemos();
//        testMaxMin();
//        testIterator();
        testFilter();
    }

    private static void testFilter() {
        List<String> list = Lists.newArrayList("a","b","c");
        Objects.requireNonNull(list);

        List<String> filterList = list.stream().filter(s ->{int len = s.length()-1;return len%2==0;}).collect(toList());

        System.out.println("filterList = " + filterList);
    }

    private static void testIterator() {
        List<String> list = Lists.newArrayList("aaa", "bbb", "ccc");

        /*for (String itm : list) {
            if (itm.equals("aaa")) {
                list.remove(itm);
            }
        }*/

        Iterator<String> it = list.iterator();
        /*

        for (int i=0;it.hasNext();i++) {
            String next = it.next();
            if (next.equals("bbb")) {
                list.remove(i);
            }
        }*/

        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
            if(str.equals("aaa")){
//                list.remove(str);
                it.remove();
            }
        }

        System.out.println(list);

    }

    private static void testMaxMin() {
        System.out.println(Math.max(1, 10));
        System.out.println(Math.min(1, 10));
    }

    /**
     * guava 方便声明、foreach lambda实现
     */
    private static void listDemos() {
        List<String> list = Lists.newArrayList("aa", "bb", "cc");

        list.forEach(s -> {
            System.out.println("s = " + s);
            System.out.println(new Date());
        });
    }
}
