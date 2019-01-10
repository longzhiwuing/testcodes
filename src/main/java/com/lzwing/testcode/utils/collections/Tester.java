package com.lzwing.testcode.utils.collections;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/5
 * Time: 19:38
 */
public class Tester {
    public static void main(String[] args) {
        testCollections();
    }

    private static void testCollections() {

        /*singleList();

        stack();

        disjoint();

        fill();

        frequency();

        swap();

        rotate();

        ncopies();

        newSetFromMap();


        */



    }

    /**
     * 统计map中相同的key的统计数量
     * @param dateLists
     * @return
     */
    private Map<String,Integer> getStatisticMap(List<Map<String,Integer>> dateLists){
        Map<String,Integer> itmMap = new HashMap<>();
        for(Map<String,Integer> map:dateLists){
            for(Map.Entry<String,Integer> en:map.entrySet()){
                int newCount = en.getValue();
                if(itmMap.containsKey(en.getKey())){//结果map中有此key
                    newCount += itmMap.get(en.getKey());
                }
                itmMap.put(en.getKey(),newCount);
            }
        }
        return itmMap;
    }

    private static void newSetFromMap() {
        Map<String, Boolean> map = new HashMap<String, Boolean>();

        System.out.println("Map is: " + map);

        // create a set from map
        Set<String> set = Collections.newSetFromMap(map);

        // add values in set
        set.add("Java");
        set.add("C");
        set.add("C++");

        // set and map values are
        System.out.println("Set is: " + set);
        System.out.println("Map is: " + map);
    }

    private static void ncopies() {
        List list = Collections.nCopies(5, "czy nb");

        System.out.println(list);
    }

    private static void rotate() {
        // create array list object
        List numbers = new ArrayList();

        // populate the list
        for (int i = 0; i < 15; i++) {
            numbers.add(i);
        }

        System.out.println("Before : "+ Arrays.toString(numbers.toArray()));

        // rotate the list at distance 10
        Collections.rotate(numbers, 10);

        System.out.println("After : "+Arrays.toString(numbers.toArray()));
    }

    private static void swap() {
        // create vector object
        Vector<String> vector = new Vector<String>();

        // populate the vector
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("4");
        vector.add("5");

        System.out.println("Before swap: "+vector);

        // swap the elements
        Collections.swap(vector, 0, 4);

        System.out.println("After swap: "+vector);
    }

    private static void frequency() {
        // create array list object
        List arrlist = new ArrayList();

        // populate the list
        arrlist.add("A");
        arrlist.add("B");
        arrlist.add("C");
        arrlist.add("C");
        arrlist.add("C");

        // check frequensy of 'C'
        int freq = Collections.frequency(arrlist, "C");

        System.out.println("Frequency of 'C' is: "+freq);
    }

    private static void singleList() {
        List<String> singletonList = Collections.singletonList("a");

        System.out.println(singletonList);
    }

    private static void stack() {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.push(5);

        //stack
        Queue<Integer> integers = Collections.asLifoQueue(deque);

        System.out.println(integers);
    }

    private static void disjoint() {
        List<String> list1 = Lists.newArrayList("java","is","ok");
        List<String> list2 = Lists.newArrayList("c++","is","good");

        //different
        System.out.println(Collections.disjoint(list1, list2));
    }

    private static void fill() {
        // create array list object
        List arrlist = new ArrayList();

        // populate the list
        arrlist.add("A");
        arrlist.add("B");
        arrlist.add("C");

        System.out.println("List elements before fill: "+arrlist);

        // fill the list with 'TP'
        Collections.fill(arrlist,"TP");

        System.out.println("List elements after fill: "+arrlist);
    }
}
