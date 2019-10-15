package com.lzwing.testcode.utils.string;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/4/15
 * Time: 12:23
 */
public class StringJoiner {
    public static void main(String[] args) {
//        commonLangJoiner();
//        testStringJoiner();
//        testJoin();
        guavaJoiner();
    }
    //传统方式
    private static void testJoin() {
        List<String> list = Lists.newArrayList("zs", "ls", "ww");
        StringBuilder sb = new StringBuilder();
        for (String itm : list) {
            sb.append(itm).append(",");
        }
        String orderIds = sb.toString();
        orderIds = orderIds.substring(0, orderIds.length() - 1);
        System.out.println(orderIds);
    }

    //java8
    private static void testStringJoiner() {
        /*java.util.StringJoiner sj = new java.util.StringJoiner("Hollis");

        sj.add("hollischuang");
        sj.add("Java干货");
        System.out.println(sj.toString());*/

        /*java.util.StringJoiner sj1 = new java.util.StringJoiner(":","[","]");

        sj1.add("Hollis").add("hollischuang").add("Java干货");
        System.out.println(sj1.toString());*/


        List<String> list = ImmutableList.of("zs","ls","ww");

        System.out.println(list.stream().collect(Collectors.joining(",")));
    }

    private static void guavaJoiner() {
        List<String> stringList = ImmutableList.of("zs","ls","ww");

        String delimiter = ",";
        String join = Joiner.on(delimiter).skipNulls().join(stringList);
        System.out.println(join);
    }

    private static void commonLangJoiner() {
        List<String> applyNameList = Lists.newArrayList("zs","ls","ww");
        String join = StringUtils.join(applyNameList, ",");

        System.out.println(join);
    }
}
