package com.lzwing.testcode.gist;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Stopwatch;
import com.google.common.collect.*;
import com.lzwing.testcode.java8.niceexample.Address;
import com.lzwing.testcode.java8.niceexample.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/11
 * Time: 17:24
 */
@Slf4j
public class Tester {
    public static void main(String[] args) throws Exception{
//        listDemos();
//        testMaxMin();
//        testIterator();
//        testFilter();
//        testArrayListAndLinkedList();
//        testFinallyReturn();
//        testJsonobj();
//        testBeanUtils();
//        testLong();
//        initListPutVal();
//        testRuntimeException();
//        testAlphaBeta();
        testGuaFen();
    }

    private static void testGuaFen() {
        double total_money=50000.00;
        int total_people=3172;
        double min_money=12.61; // 每个人最少能收到0.05元、
        double max_money=18.91; // 每个人最少能收到0.05元、
        double lingjiezhi=(total_money/total_people)*100;
        double allresult=0;
        for (int i = 0; i <total_people; i++) {
//保护值
            double procte=(total_people-i-1)*min_money/100;;
//可支配金额
            double zpje=total_money-procte;
            if(zpje*100<max_money){
                max_money=zpje*100;
            }
            double result=restRound(min_money, max_money, i, zpje, total_people-1);
            total_money=total_money-result;
            allresult+=result;
            System.out.format("红包  %.2f,余额  %.2f \n",result,total_money);
        }
        System.out.format("总金额%.2f",allresult);
    }


    public static double restRound(double min,double max,int i,double money,int count){
        double redpac=0;
        if(i==19){
            redpac=money;
        }else{
            redpac=(Math.random()*(max-min)+min)/100;
        }
        return redpac;
    }

    private static void testAlphaBeta() {
//        System.out.println((int) "A".charAt(0));
        String str = "M10";

        System.out.println(str.substring(str.length()-1));
    }

    private static void testRuntimeException() {
        try {
            throw new ArrayIndexOutOfBoundsException(3);
        } catch (Exception e) {
            System.out.println("exception:" + e);
        }
    }


    private static void initListPutVal() {
        /*ConcurrentHashMap<String, List<String>> hashFilter = new ConcurrentHashMap<>({
                put("pre",new ArrayList<String>())
        });*/

        Map<String, String> map = new HashMap<String,String>(){{
            put("1","zs");
            put("2","ls");
            put("3","ww");
        }};

        System.out.println("map = " + map);

        List<String> zs = new ArrayList<String>() {{
            add("zs");
            add("ls");
            add("ww");
        }};

        System.out.println("zs = " + zs);

        List<String> strings = new ArrayList<>(Arrays.asList("hello@world", "good@bye", "love@you"));

        System.out.println("strings = " + strings);




    }

    private static void testLong() {
        Long aLong = Long.valueOf("");
        System.out.println("aLong = " + aLong);
    }

    private static void testBeanUtils() throws Exception{
        /*Map<String, String> origin = new HashMap<>();
        origin.put("111", "aaa");
        origin.put("222", "bbb");
        origin.put("444", "ccc");

        Map<String, String> dest = new HashMap<>();
        dest.put("111", "xxx");
        dest.put("333", "yyy");
        dest.put("444", "zzz");*/

        User origin = new User();
        origin.setName("zhangsan");
        Address address = new Address();
        address.setCity("beiing");
        origin.setAddress(address);

        User dest = new User();
        dest.setName("lisi");
        address = new Address();
        address.setCity("shanghai");
//        dest.setAddress(address);

        BeanUtils.copyProperties(origin,dest);

        System.out.println("origin = " + origin);
        System.out.println("dest = " + dest);
    }

    private static void testJsonobj() {
        JSONObject dataObj = new JSONObject();
        String aaaa = dataObj.getString("aaaa");
        System.out.println("aaaa = " + aaaa);
    }

    private static void testFinallyReturn() {
        for(int i=0;i<10;i++) {
            int returnValue = getReturnValue();
            log.info("return value:{}",returnValue);
        }
    }

    private static int getReturnValue() {
        try {
            if (RandomUtils.nextInt()%2==0) {
                throw new Exception("test");
            }
            return 1;
        } catch (Exception e) {
            return 2;
        }finally {
            return 3;
        }
    }

    private static void testArrayListAndLinkedList() {
        int count = 100000;
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
        }
        stopwatch.stop();
        System.out.println("Array time:"+stopwatch.elapsedTime(TimeUnit.MILLISECONDS));

        list = new LinkedList<String>();
        for(int i=0;i<count;i++) {
            list.add(i+"");
        }
        stopwatch = new Stopwatch();
        stopwatch.start();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
        }
        stopwatch.stop();
        System.out.println("linklist time:"+stopwatch.elapsedTime(TimeUnit.MILLISECONDS));
    }

    private static void testFilter() {
        List<String> list = Lists.newArrayList("a","b","c");
        Objects.requireNonNull(list);

        List<String> filterList = list.stream().filter(s ->{int len = s.length()-1;return len%2==0;}).collect(toList());

        System.out.println("filterList = " + filterList);
    }

    private static void testIterator() {
        List<String> list = Lists.newArrayList("aaa", "bbb", "ccc");

        /*for (String itm : list) {
            if (itm.equals("aaa")) {
                list.remove(itm);
            }
        }*/

        Iterator<String> it = list.iterator();
        /*

        for (int i=0;it.hasNext();i++) {
            String next = it.next();
            if (next.equals("bbb")) {
                list.remove(i);
            }
        }*/

        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
            if(str.equals("aaa")){
//                list.remove(str);
                it.remove();
            }
        }

        System.out.println(list);

    }

    private static void testMaxMin() {
        System.out.println(Math.max(1, 10));
        System.out.println(Math.min(1, 10));
    }

    /**
     * guava 方便声明、foreach lambda实现
     */
    private static void listDemos() {
        List<String> list = Lists.newArrayList("aa", "bb", "cc");

        list.forEach(s -> {
            System.out.println("s = " + s);
            System.out.println(new Date());
        });
    }
}
