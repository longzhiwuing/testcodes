package com.lzwing.testcode.gist;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.lzwing.testcode.java8.niceexample.Address;
import com.lzwing.testcode.java8.niceexample.User;
import com.lzwing.testcode.utils.other.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.commons.lang3.RandomUtils;
import org.mockito.Mockito;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileFilter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
    public static final Map<Integer, Integer> typeMap = new HashMap<Integer, Integer>() {
        {
            put(4, 1);
            put(6, 1);
            put(1, 1);
            put(8, 1);
            put(7, 2);
            put(9, 2);
            put(14, 2);
            put(2, 2);
            put(5, 3);
            put(15, 3);
            put(16, 3);
            put(13, 3);
            put(10, 4);
            put(11, 4);
            put(12, 4);
            put(3, 4);
        }
    };
    private static AtomicInteger totalCount = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
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
//        testGuaFen();
//        testDivide();
//        testVectorDelete();
//        testDeadLoopTest();
//        testFileFilter();
//        testDateFunc();
//        testprobablePrime();
//        testSplit();
//        testX();
//        testCalendar();
//        testless18Chars();
//        testDJS();
//        testBigDecimal();
//        testNumberConverter();
//        testCountDown();
//        testTypeMap();
//        testAtomic();
//        testFileTransferTo();
//        testProperties();
//        testTime();

//        testGetData();

//        testMapUtils();

//        testDebug();

//        testFilePath();

//        testStringFormat();

//        testTreeMap();
//        testStringBuffterReverse();

        testJarFile();
    }

    private static void testJarFile() throws Exception{
        String jarFilePath = "/Users/longzhiwu/softwares/devtools/mavenJars/repository/cn/afterturn/easypoi-base/3.2.0/easypoi-base-3.2.0.jar";
        JarFile jarFile = new JarFile(jarFilePath);

        Enumeration<JarEntry> entries = jarFile.entries();
        int i=0;
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            System.out.println(entry.getName());
        }
    }

    private static void testStringBuffterReverse() {
        String test = "abcdefg";
        StringBuffer reverse = new StringBuffer(test).reverse();
        System.out.println(reverse.toString());
    }

    private static void testTreeMap() {
        ComapreObj comapreObj1 = new ComapreObj(1);
        ComapreObj comapreObj2 = new ComapreObj(2);

        TreeMap<ComapreObj, String> treeMap = new TreeMap<>();
        treeMap.put(comapreObj1, "aaa");
        treeMap.put(comapreObj2, "bbb");

        System.out.println(treeMap);
    }

    private static void testStringFormat() {
        CollectionUtils.isEmpty(new ArrayList());
        System.out.println(String.format("%s.%%", "n"));
    }

    private static void testFilePath() {
        File file = new File("/Users/longzhiwu/Resources/研词/wordmp3");

        if (file.exists() && file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (Objects.equals(f.getName(), ".DS_Store")) {
                    continue;
                }
                //System.out.println(f.getName());
            }
        }
    }

    private static void testDebug() {
        System.out.println("begin...");
        int a = 0;
        System.out.println("init");
        if (a == 1) {
            System.out.println("a==1");
        }

        if (a == 2) {
            System.out.println("a==2");
        }
    }

    private static void testMapUtils() {
        Map<String, Object> map = new HashMap<>();
        List<String> lists = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(lists));

        System.out.println(MapUtils.isEmpty(map));
    }

    private static void testGetData() {
        Calendar c = Calendar.getInstance();
        c.set(2019,0,21);
        Date start = c.getTime();
        c.set(2019, 0, 28);
        Date end = c.getTime();

        Map<String, Object> data = getData(start, end);

        System.out.println(data);
    }

    public static Map<String, Object> getData(Date startTime,Date endTime) {
        Map<String, Object> dataMap = new HashMap<>();
        LocalDate stLocalDate = DateTimeUtil.date2localDate(startTime);
        LocalDate edLocalDate = DateTimeUtil.date2localDate(endTime);

        LocalDate stNextWeekMonday = stLocalDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        //获取开始日期当周的星期一
        LocalDate stWeekMonday = stNextWeekMonday.plus(-1, ChronoUnit.WEEKS);
        //获取结束日期当周的星期天
        LocalDate edWeekSunday = edLocalDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        Period p = Period.between(stWeekMonday, edWeekSunday);

        long periodDays = p.get(ChronoUnit.DAYS);
        long weekCount = periodDays / 7 + 1;

        dataMap.put("weekCount", weekCount);
        LocalDate itm = stWeekMonday;
        LocalDate lastDay = edWeekSunday.plus(1, ChronoUnit.DAYS);
        List<List<String>> dateWeekList = new ArrayList<>();
        List<String> weekList = null;
        int dayCount = 0;
        while (itm.compareTo(lastDay) != 0) {
            if (dayCount == 0) {
                weekList = new ArrayList<>();
            }
            weekList.add(DateTimeUtil.getDate(DateTimeUtil.localDate2Date(itm)));
            dayCount++;
            if (dayCount == 7) {
                dateWeekList.add(weekList);
                dayCount = 0;
            }
            itm = itm.plus(1, ChronoUnit.DAYS);
        }

        dataMap.put("dateWeekList", dateWeekList);

        return dataMap;
    }

    private static void testTime() {
        LocalDate now = LocalDate.now();
        LocalDate nextWeekMonday = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate nextWeekMonday1 = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        System.out.println(nextWeekMonday.compareTo(nextWeekMonday1));

        /*//获取开始日期当周的星期一
        LocalDate thisWeekMonday = nextWeekMonday.plus(-1, ChronoUnit.WEEKS);
        //获取开始日期当周的星期天
        LocalDate thisWeekSunday = nextWeekMonday.plus(-1, ChronoUnit.DAYS);
        Period p = Period.between(thisWeekMonday, thisWeekSunday);
        long periodDays = p.get(ChronoUnit.DAYS);
        long week = periodDays / 7;


        System.out.println(week);*/
    }

    private static void testProperties() {
        //vm options: -Daaa=bbb
        String property = System.getProperty("aaa");
        System.out.println(property);
    }

    private static void testFileTransferTo() throws Exception{
        MultipartFile multipartFile = Mockito.mock(MultipartFile.class);
        multipartFile.transferTo(new File("/"));

        Mockito.verify(multipartFile).transferTo(new File("/"));
    }


    private static void testAtomic() {
//        IOUtils.closeQuietly(oos);
        List list = new ArrayList();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        totalCount.addAndGet(list.size());
        list.size()
        ;

        System.out.println(totalCount.get());
    }

    private static void testTypeMap() {
        System.out.println(typeMap.get(null));
    }

    private static void testCountDown() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dd = DurationFormatUtils.formatPeriod(new Date().getTime(), sdf.parse("2018-12-11 00:00:00").getTime(), "dd");

        System.out.println(dd);
    }

    public static String longto36(Long x) {
        String[] a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Long b = x;
        String nb = "";
        while (b != 0) {
            Long c = b % 36;
            Long d = b / 36;
            nb = a[c.intValue()] + nb;
            b = Math.round(Math.floor(d));
        }
        switch (nb.length() % 6) {
            case 0:
                return nb;
            case 1:
                return "00000" + nb;
            case 2:
                return "0000" + nb;
            case 3:
                return "000" + nb;
            case 4:
                return "00" + nb;
            case 5:
                return "0" + nb;
            default:
                return "";
        }
    }

    private static void testNumberConverter() {
        /*System.out.println("把10进制，转化为2,8,16进制：");
        System.out.println(Integer.toString(10));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toOctalString(10));
        System.out.println(Integer.toHexString(10));*/
        /*System.out.println(Integer.toString(100,36));

        String s = longto36(Long.parseLong("100"));
        System.out.println(s);*/

        /*for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtils.nextInt(11, 21));
        }*/

        /*String favoriteTeacher = "";
        System.out.println(StringUtils.defaultIfEmpty(favoriteTeacher, "某位老师"));
        favoriteTeacher = null;
        System.out.println(StringUtils.defaultIfEmpty(favoriteTeacher, "某位老师"));
        favoriteTeacher = "张三";
        System.out.println(StringUtils.defaultIfEmpty(favoriteTeacher, "某位老师"));*/

        int inviteCount = 3;
        int PRIZE_INVITE_COUNT = 10;
        //int percent = (int) ((double) inviteCount / PRIZE_INVITE_COUNT) * 100;
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        String format = percentFormat.format((double) inviteCount / PRIZE_INVITE_COUNT);

        System.out.println(format);
    }

    private static void testBigDecimal() {
        BigDecimal totalLearningTime = new BigDecimal(1.99);
        totalLearningTime = totalLearningTime.setScale(0, BigDecimal.ROUND_UP);

        System.out.println(totalLearningTime);
    }

    private static void testDJS() throws Exception {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse("2018-12-23");
        String dd = DurationFormatUtils.formatPeriod(today.getTime(), parse.getTime(), "dd");
        System.out.println(dd);
    }

    private static void testless18Chars() {
        String content = "我今天打卡了，凑够18个字我今天打卡了，凑够18个字我今天打卡了，凑够18个字我今天打卡了，凑够18个字我今天打卡了，凑够18个字我今天打卡了，凑够18个字";

        if (content.length() >= 18) {
            content = String.format("%s...", content.substring(0, 18));
        }

        System.out.println(content);
    }

    private static void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.NOVEMBER, 24, 0, 0, 0);
        Date dateTime = calendar.getTime();
        Date now = new Date();
        if (now.after(dateTime)) {
            System.out.println("after...");
        } else {
            System.out.println("before...");
        }
    }

    private static void testX() {

        for (int i = 1; i <= 1000; i++) {
            boolean f1 = (i - 5) % 5 == 0;
            boolean f2 = (i - 6) % 6 == 0;
            boolean f3 = (i - 7) % 7 == 0;
            if (f1 && f2 && f3) {
                System.out.println(i);
            }
        }
    }

    private static void testSplit() {

        List<String> insertOpenIdList = new ArrayList<>();

        for (int i = 0; i < 12345; i++) {
            insertOpenIdList.add(i + "");
        }

        for (int i = 0; i < insertOpenIdList.size(); i += 100) {
            int min = Math.min(i + 100, insertOpenIdList.size());
            List<String> list2Insert = insertOpenIdList.subList(i, min);
            System.out.println(list2Insert);
        }



        /*String str = "高等数学:::2018-11-23 11:30";

        System.out.println(str.split(":::")[0]);
        System.out.println(str.split(":::")[1]);*/

        /*System.out.println(str.indexOf("x"));

        System.out.println(str.split("\\?")[0]);*/
    }

    private static void testprobablePrime() throws Exception {
        BigInteger p = BigInteger.ONE;
        while (true) {
            System.out.println("p:" + p);
            p = p.nextProbablePrime();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private static void testDateFunc() {

    }

    private static void testFileFilter() {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };
    }

    private static void testDeadLoopTest() throws Exception {
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(new Date());
        }
    }

    private static void testVectorDelete() throws Exception {
//        Vector<Integer> vector = new Vector<>();

//        List<Integer> vector = new ArrayList<>();
//        List<Integer> vector = Collections.synchronizedList(new ArrayList<>());
        List<Integer> vector = new CopyOnWriteArrayList<>();

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        vector.add(7);
        vector.add(8);
        vector.add(9);
        vector.add(10);

        Iterator<Integer> iterator = vector.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() == 5) {
                //iterator.remove();
                vector.remove(iterator.next());
            }
        }


        System.out.println(vector);
/*
//        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 2) {
                map.remove(entry.getKey());
            }
        }

        System.out.println(map);*/


    }

    private static void testDivide() {
        System.out.println((int) (((float) 97.5 / 100) * 100));
    }

    private static void testGuaFen() {
        double total_money = 50000.00;
        int total_people = 3172;
        double min_money = 12.61; // 每个人最少能收到0.05元、
        double max_money = 18.91; // 每个人最少能收到0.05元、
        double lingjiezhi = (total_money / total_people) * 100;
        double allresult = 0;
        for (int i = 0; i < total_people; i++) {
//保护值
            double procte = (total_people - i - 1) * min_money / 100;
            ;
//可支配金额
            double zpje = total_money - procte;
            if (zpje * 100 < max_money) {
                max_money = zpje * 100;
            }
            double result = restRound(min_money, max_money, i, zpje, total_people - 1);
            total_money = total_money - result;
            allresult += result;
            System.out.format("红包  %.2f,余额  %.2f \n", result, total_money);
        }
        System.out.format("总金额%.2f", allresult);
    }


    public static double restRound(double min, double max, int i, double money, int count) {
        double redpac = 0;
        if (i == 19) {
            redpac = money;
        } else {
            redpac = (Math.random() * (max - min) + min) / 100;
        }
        return redpac;
    }

    private static void testAlphaBeta() {
//        System.out.println((int) "A".charAt(0));
        String str = "M10";

        System.out.println(str.substring(str.length() - 1));
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

        Map<String, String> map = new HashMap<String, String>() {{
            put("1", "zs");
            put("2", "ls");
            put("3", "ww");
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

    private static void testBeanUtils() throws Exception {
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

        BeanUtils.copyProperties(origin, dest);

        System.out.println("origin = " + origin);
        System.out.println("dest = " + dest);
    }

    private static void testJsonobj() {
        JSONObject dataObj = new JSONObject();
        String aaaa = dataObj.getString("aaaa");
        System.out.println("aaaa = " + aaaa);
    }

    private static void testFinallyReturn() {
        for (int i = 0; i < 10; i++) {
            int returnValue = getReturnValue();
            log.info("return value:{}", returnValue);
        }
    }

    private static int getReturnValue() {
        try {
            if (RandomUtils.nextInt() % 2 == 0) {
                throw new Exception("test");
            }
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    private static void testArrayListAndLinkedList() {
        int count = 100000;
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
        }
        stopwatch.stop();
        System.out.println("Array time:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        list = new LinkedList<String>();
        for (int i = 0; i < count; i++) {
            list.add(i + "");
        }
        stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
        }
        stopwatch.stop();
        System.out.println("linklist time:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    private static void testFilter() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        Objects.requireNonNull(list);

        List<String> filterList = list.stream().filter(s -> {
            int len = s.length() - 1;
            return len % 2 == 0;
        }).collect(toList());

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

        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
            if (str.equals("aaa")) {
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
