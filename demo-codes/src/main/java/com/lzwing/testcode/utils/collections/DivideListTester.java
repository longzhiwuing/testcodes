package com.lzwing.testcode.utils.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/6/6
 * Time: 15:32
 */
public class DivideListTester {
    /**
     * 均拆List
     * @param sourceList 待拆list
     * @param divideCount 拆分个数
     * @param <T>
     * @return
     */
    public static  <T> List<List<T>> divideList(List<T> sourceList, int divideCount) {
        List<List<T>> subLists = new ArrayList<>();
        int subCount = sourceList.size() / divideCount;
        int index = 0;
        while (index < sourceList.size()) {
            int from = index;
            index += subCount;
            int to = index;
            if (index > sourceList.size()) {
                to = sourceList.size();
            }
            System.out.printf("from:%d to:%d%n", from, to);
            subLists.add(sourceList.subList(from, to));
        }
        return subLists;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            list.add(i);
        }

        List<List<Integer>> lists = divideList(list, 3);

        System.out.println(lists);
    }
}
