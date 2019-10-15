package com.lzwing.testcode.utils.nullexception;

import lombok.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/16
 * Time: 11:30
 */
public class Test {
    public static void main(String[] args) {
//         nullErrorTest();
        /*List<String> emptyList = createDefaultEmptyCollection();
        System.out.println(emptyList.size());*/
        /*String s = String.valueOf(null);
        System.out.println(s);*/

        testParam("bbb", 2);

    }

    private static void testParam(@NonNull String str, @NonNull Integer i) {
        System.out.printf("%s%d%n", str, i);
    }

    private static List<String> createDefaultEmptyCollection() {
        List<String> data = Collections.EMPTY_LIST;
        return data;
    }

    private static void nullErrorTest() {
        Map numberAndCount = new HashMap<>();
        int[] numbers = {3, 5, 7,9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};

        for(int i : numbers){
            int count = (int) numberAndCount.get(i);
            numberAndCount.put(i, count++); // NullPointerException here
        }
    }
}
