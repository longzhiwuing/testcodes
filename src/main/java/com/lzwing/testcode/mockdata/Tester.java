package com.lzwing.testcode.mockdata;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * 随机获得List数据中的部分数据
 *
 * @author: chenzhongyong
 * Date: 2019/5/25
 * Time: 20:13
 */
public class Tester {


    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 31; i++) {
            dataList.add(i);
        }

        List<Integer> randomElems = getRandomElems(dataList, 20);

        System.out.println(randomElems);
        System.out.println(randomElems.size());
    }

    private static List<Integer> getRandomElems(List<Integer> dataList, int i) {
        Set<Integer> sets = new TreeSet<>();

        while (sets.size() < i) {
            int randIndex = RandomUtils.nextInt(0, dataList.size());
            sets.add(randIndex);
        }

        List<Integer> randList = new ArrayList<>();
        for (Integer rand : sets) {
            randList.add(rand);
        }

        return randList;
    }
}
