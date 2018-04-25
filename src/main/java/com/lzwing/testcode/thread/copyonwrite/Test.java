package com.lzwing.testcode.thread.copyonwrite;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/16
 * Time: 9:16
 */
public class Test {
    public static void main(String[] args) {
        exceptionDemo();
//        iteratorDemo();
    }

    private static void exceptionDemo() {
//        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6);

        List<Integer> list = Lists.newCopyOnWriteArrayList();
        for (int i = 1; i <= 6; i++) {
            list.add(i);
        }

        for (Integer integer : list) {
            if (integer == 4) {
                list.remove(integer);
            }
        }

        System.out.println(list);

    }

    private static void iteratorDemo() {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() == 4) {
                list.remove(iterator.next());
            }
        }

        System.out.println(list);

    }

}
