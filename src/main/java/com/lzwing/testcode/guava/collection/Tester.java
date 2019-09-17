package com.lzwing.testcode.guava.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/9/6
 * Time: 17:15
 */
public class Tester {
    public static void main(String[] args) {
        testPartition();
    }

    private static void testPartition() {
        List<Integer> tempResearchAreas = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            tempResearchAreas.add(i);
        }


        List<List<Integer>> partition = Lists.partition(tempResearchAreas, 20);

        System.out.println("before partition:"+partition);

        tempResearchAreas.removeAll(tempResearchAreas);

        System.out.println("tempResearchAreas:"+tempResearchAreas);

        System.out.println("after partition:"+partition);


    }
}
