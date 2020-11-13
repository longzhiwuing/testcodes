package com.lzwing.testcode.guava.collection;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/9/6
 * Time: 17:15
 */
public class CollectionTester {
    public static void main(String[] args) {
        testMultiMap2();
    }

    private static void testPartition() {
        List<Integer> tempResearchAreas = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            tempResearchAreas.add(i);
        }


        List<List<Integer>> partition = Lists.partition(tempResearchAreas, 20);

        System.out.println("before partition:" + partition);

        tempResearchAreas.removeAll(tempResearchAreas);

        System.out.println("tempResearchAreas:" + tempResearchAreas);

        System.out.println("after partition:" + partition);


    }

    private static void testMultiMap2() {
        // Multimaps
        // Multimaps提供了若干值得单独说明的通用工具方法
        // index
        // 作为Maps.uniqueIndex的兄弟方法，Multimaps.index(Iterable,Function)
        // 通常针对的场景是：有一组对象，它们有共同的特定属性，我们希望按照这个属性的值查询对象，但属性值不一定是独一无二的。
        // 比方说，我们想把字符串按长度分组。
        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String string) {
                return string.length();
            }
        };

        ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);


        // {4=[zero, four, five, nine], 3=[one, two, six], 5=[three, seven,
        // eight]}
        System.out.println(digitsByLength);

    }

    private static void testMultiMap3() {
        // invertFrom
        // 鉴于Multimap可以把多个键映射到同一个值也可以把一个键映射到多个值，反转Multimap也会很有用。Guava
        // 提供了invertFrom(Multimap toInvert,
        // Multimap dest)做这个操作，并且你可以自由选择反转后的Multimap实现。
        // 注：如果你使用的是ImmutableMultimap，考虑改用ImmutableMultimap.inverse()做反转。
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));


        TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, TreeMultimap.create());
        // {1=[a], 2=[a, b, c], 3=[c], 4=[a, b], 5=[c], 6=[b]}
        System.out.println(inverse);
    }

    private static void testMultiMap4() {

        // 想在Map对象上使用Multimap的方法吗？forMap(Map)把Map包装成SetMultimap。
        //这个方法特别有用，例如，与Multimaps.invertFrom结合使用，可以把多对一的Map反转为一对多的Multimap。
        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        SetMultimap<String, Integer> multimap = Multimaps.forMap(map);
        System.out.println(multimap);
        // multimap：{a=[1], b=[1], c=[2]}
        Multimap<Integer, String> inverse = Multimaps.invertFrom(multimap, HashMultimap.create());
        // {1=[a, b], 2=[c]}
        System.out.println(inverse);
    }


    private static void testMultiMap() {
        Multimap<Integer, String> multimap = ArrayListMultimap.create();

        multimap.put(1, "111");
        multimap.put(1, "222");
        multimap.put(1, "333");
        multimap.put(2, "aaa");
        multimap.put(2, "bbb");
        multimap.put(3, "CCC");

        Set<Integer> yearSet = multimap.keySet();

        if (CollectionUtils.isEmpty(yearSet)) {
            return;
        }

        Map<Integer, Map> dataMap = new HashMap<>();
        for (Integer year : yearSet) {
            Map<String, Integer> yearMap = new HashMap<>();
            Collection<String> yearNames = multimap.get(year);
            for (String yearName : yearNames) {
                yearMap.put(yearName, year);
            }
            dataMap.put(year, yearMap);
        }

        System.out.println(dataMap);
    }
}
