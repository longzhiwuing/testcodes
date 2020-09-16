package com.lzwing.testcode.java8.map;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/9/16
 * Time: 22:57
 */
public class Tester {
    public static void main(String[] args) {
//        testPutifabsent();
        testOther();

    }

    private static void testOther() {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

        /**
         * 1.getOrDefault 方法
         *
         * 如果指定的key存在，则返回该key对应的value，
         * 如果不存在，则返回指定的值。
         *
         * 例子:key为4不存在，输出d
         */
        System.out.println(map.getOrDefault(4,"d"));

        System.out.println(StringUtils.repeat("=", 50));

        /**
         * 2.forEach 方法
         *
         * 遍历Map中的所有Entry, 对key, value进行处理，
         接收参数 (K, V) -> void,
         */
        map.forEach((key,value) -> System.out.println("key : " + key + " , value:" + value));

        System.out.println(StringUtils.repeat("=", 50));

        /**
         * 3.replaceAll 方法
         * 替换Map中所有Entry的value值，这个值由旧的key和value计算得出，
         接收参数 (K, V) -> V
         */
        map.replaceAll((key,value) -> ("new" + key) + value);
        map.forEach((key,value) -> System.out.println("key : " + key + " , value:" + value));

        System.out.println(StringUtils.repeat("=", 50));

        /**
         * 4.putIfAbsent 方法
         * 如果key关联的value不存在，则关联新的value值，返回key关联的旧的值
         */
        map.putIfAbsent(3, "d");
        map.putIfAbsent(4, "d");
        System.out.println(map.get(3));
        System.out.println(map.get(4));

        System.out.println(StringUtils.repeat("=", 50));

        /**
         * 5.remove方法
         * 接收2个参数，key和value，如果key关联的value值与指定的value值相等（equals)，则删除这个元素
         */
        map.remove(1,"b");
        //未删除成功，输出a
        System.out.println(map.get(1));

        map.remove(2,"b");
        //删除成功，输出null
        System.out.println(map.get(2));

        System.out.println(StringUtils.repeat("=", 50));

        /**
         * 6.replace(K key, V oldValue, V newValue) 方法
         * 如果key关联的值与指定的oldValue的值相等，则替换成新的newValue
         */
        map.replace(3,"a","z");
        //未替换成功,输出c
        System.out.println(map.get(3));


        map.replace(1,"a","z");
        //替换成功，输出z
        System.out.println(map.get(1));

        System.out.println(StringUtils.repeat("=", 50));


        /**
         * 7.replace(K key, V value) 方法
         * 如果map中存在key，则替换成value值，否则返回null
         */
        // 输出旧的值， a
        System.out.println(map.replace(1, "aa"));
        // 替换成功，输出新的值， aa
        System.out.println(map.get(1));

        // 不存在key为4， 输出 null
        System.out.println(map.replace(4, "d"));
        // 不存在key为4， 输出 null
        System.out.println(map.get(4));

        System.out.println(StringUtils.repeat("=", 50));

        /**
         * 8.computeIfAbsent 方法
         * 如果指定的key不存在，则通过指定的K -> V计算出新的值设置为key的值
         */
        map.computeIfAbsent(1, key -> key + " computed");
        // 存在key为1，则不进行计算，输出值 a
        System.out.println(map.get(1));

        map.computeIfAbsent(4, key -> key + " computed");
        // 不存在key为4，则进行计算，输出值 4 computed
        System.out.println(map.get(4));

        System.out.println(StringUtils.repeat("=", 50));


        /**
         * 9.computeIfPresent 方法
         * 如果指定的key存在，则根据旧的key和value计算新的值newValue,
         * 如果newValue不为null，则设置key新的值为newValue,
         * 如果newValue为null, 则删除该key的值，
         */
        map.computeIfPresent(1, (key, value) -> (key + 1) + value);
        // 存在key为1， 则根据旧的key和value计算新的值，输出 2a
        System.out.println(map.get(1));

        map.computeIfPresent(2, (key, value) -> null);
        // 存在key为2， 根据旧的key和value计算得到null，删除该值，输出 null
        System.out.println(map.get(2));



    }

    private static void testPutifabsent() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 1));
        list.add(new Student("李四", 1));
        list.add(new Student("王五", 2));
        list.add(new Student("赵六", 1));
        list.add(new Student("孙七", 2));
        list.add(new Student("周八", 1));
        list.add(new Student("吴九", 2));

        //对于上面的学生、如果根据班级进行区分？！
        Map<Integer,List<Student>> map = new HashMap<>();
        List<Student> students;
        for(Student s : list) {
            /**
             * put不管什么直接存入，返回旧值
             * putIfAbsent如果为null才存入，返回旧值。
             */
            students = map.putIfAbsent(s.getInClass(),new ArrayList<Student>(list.size()));
            if (null == students) {
                students = map.get(s.getInClass());
            }
            students.add(s);
        }

        //循环Map
        map.forEach((key,value) -> {
            System.out.println("班级:" + key + ",人员:" + JSON.toJSONString(value));
        });
    }
}
