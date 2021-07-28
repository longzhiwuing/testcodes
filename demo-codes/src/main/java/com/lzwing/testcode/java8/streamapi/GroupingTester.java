package com.lzwing.testcode.java8.streamapi;

import com.lzwing.testcode.java8.niceexample.Address;
import org.fest.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/28
 * Time: 12:04
 */
public class GroupingTester {
    public static void main(String[] args) {

        List<Address> a1List = Lists.newArrayList(new Address("bj"),new Address("tj"),new Address("gz"));
        List<Address> a2List = Lists.newArrayList(new Address("hz"),new Address("bj"),new Address("sh"));
        Student s1 = new Student(1, "zs", "M", 172, a1List);
        Student s2 = new Student(2, "ls", "F", 172, a2List);

        List<Student> studentList = Lists.newArrayList(s1,s2);

        Map<Integer, List<Address>> noAddresMap = studentList.stream().collect(Collectors.toMap(Student::getNo, Student::getAddressList));

        Map<String, List<Student>> groupingListMap = studentList.stream().collect(Collectors.groupingBy(Student::getName));

        Map<String, Set<Student>> groupbingSetMap = studentList.stream().collect(Collectors.groupingBy(Student::getName, toSet()));

        Map<String, Long> groupingGenderCountMap = studentList.stream().collect(Collectors.groupingBy(Student::getSex, counting()));

        Map<String, Optional<Student>> groupingSexGetMaxHeightMap = studentList.stream().collect(groupingBy(Student::getSex, maxBy(Comparator.comparing(Student::getHeight))));

        Map<Integer, Double> totalHeightGroupingByStuNoMap = studentList.stream().collect(groupingBy(Student::getNo, summingDouble(Student::getHeight)));

        String nameJoinner = studentList.stream().map(Student::getName).collect(joining(","));

        System.out.println(nameJoinner);
    }
}
