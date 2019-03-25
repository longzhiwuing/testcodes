package com.lzwing.testcode.owntest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/3/23
 * Time: 17:03
 */
public class AhaTester {

    public static void main(String[] args) {
        List<Integer> origin = Lists.newArrayList(6, 3, 1, 7, 5, 8, 9, 2, 4);

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < origin.size(); i++) {
            queue.addLast(origin.get(i));
        }

        List<Integer> result = new ArrayList<>();

        int i = 0;
        while (queue.size() > 0) {
            if (i % 2 == 0) {
                result.add(queue.pollFirst());
            } else {
                queue.addLast(queue.pollFirst());
            }
            i++;
        }

        System.out.println(result);

    }
}
