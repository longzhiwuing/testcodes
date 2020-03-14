package com.lzwing.testcode.gist;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.lzwing.testcode.java8.niceexample.Address;
import com.lzwing.testcode.java8.niceexample.User;
import com.lzwing.testcode.time.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.mockito.Mockito;
import org.springframework.util.CollectionUtils;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public static Map<Integer,Map<Integer, Date>> timeMap;

    static {
        timeMap = getTimeMap();
    }

    public static Map<Integer,Map<Integer, Date>> getTimeMap() {

        Map<Integer,Map<Integer, Date>> timeMap = new LinkedHashMap<>();

        int year = 2019;
        int month = 12;
        int dayBegin = 21;
        int dayEnd = 26;

        for (int i = dayBegin; i < dayEnd; i++) {
            Map<Integer, Date> dayTimeMap = new LinkedHashMap<>();
            dayTimeMap.put(10, new DateTime(year, month, i, 10, 0, 0).toDate());
            dayTimeMap.put(12, new DateTime(year, month, i, 12, 0, 0).toDate());
            dayTimeMap.put(18, new DateTime(year, month, i, 18, 0, 0).toDate());
            dayTimeMap.put(20, new DateTime(year, month, i, 20, 0, 0).toDate());
            dayTimeMap.put(22, new DateTime(year, month, i, 22, 0, 0).toDate());
            timeMap.put(i, dayTimeMap);
        }

        return timeMap;

    }

    public static void main(String[] args) throws Exception {

        testMultiMap();

//        testCount();
//        testContains();

//        testColorPattern();
//        testOmmit();

//        testReplaceAll();

//        testTimeMap();
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

//        testJarFile();
//        testInteger();

//        testTryCatchOrder();

//        testListRemove();


//        testJodaTime();

//        testBinaryInteger();

//        testRandom();
//        testNan();
//        testJsArray();
//        testCommonJars();
//        testLong();
//        testLoop();
//        testLoopThreadPool();
//        testPriorityQueue();
//        testHashCode();
//        testThread();
//        testThreadCount();
//        testGetDigit();
//        testTryCatchOrder();

//        testStopWatch();
//        testDivide();
//        testZhengZe();
//        testIpp();
//        testJSONParse();
//        testAtomicTest();
//        testJodaTime();
//        testTime();
//        testIndexOf();
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

    private static void testContains() {
        /*String url = "//m.neibu.koolearn.com/product/c_2_104036.html?_mobile=true";

        if (url.contains("//")) {
            url = url.replace("//", "");
            System.out.println(url);
        }*/

        List<Integer> idList = Lists.newArrayList(14853,14852,14851,14849,14848,14847,14846,14845,14844,14843,14842,14841,14840,14839,14838,14837,14836,14835,14834,14833,14832,14525,14524,14522,14520,14517,14516,14028,14023,13331,12855,8625,8624,8623,8622,8621,8605,8604,8603,8520,8453,8352,8351,8264,8263,8250,8249,8248,8247,7942,7641,7940,7939,7938,7937,7936,7934,7933,7904,7903,7902,24426,24311,24274,24267,18157,18156,18155,18153,18152,18151,18150,18149,18148,18147,18146,18145,18144,18143,18142,18141,18140,18115,18114,18113,18112,18111,18110,14033,14032,14031,14030,14029,9385,9384,9383,7929,7928,7927,7926,7924,7946, 7948, 7950, 7951, 7953, 7955, 8286, 24725, 7956);


        List<Integer> checkIdList = Lists.newArrayList(14976, 16257, 14274, 48195, 11847, 16712, 14348, 16076, 16716, 17676, 9998, 13263, 8655, 18129, 40660, 15957, 48533, 48917, 14422, 18074, 48413, 19167, 13472, 15905, 48547, 48548, 18088, 12586, 17963, 14447, 40560, 12535, 16248, 48888, 14201, 15545, 17274, 13695,18149);


        for (Integer checkId : checkIdList) {
            if (idList.contains(checkId)) {
                System.out.println("ok");
                return;
            }
        }

        System.out.println("none");





        System.out.println(idList.size());
    }

    private static void testCount() {
        String count = "1";
        System.out.println(NumberUtils.isDigits(count));

        count = "a";

        System.out.println(NumberUtils.isDigits(count));

        count = "23,324,234";

        System.out.println(NumberUtils.isDigits(count));

        count = "23.3423";

        System.out.println(NumberUtils.isDigits(count));

        count = "23.abc";

        System.out.println(NumberUtils.isDigits(count));
    }

    private static void testOmmit() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            list.add(i);
        }
        String paramInfo = JSON.toJSONString(list);
        if (StringUtils.isNotBlank(paramInfo) && paramInfo.length() > 200) {
            paramInfo = String.format("%s...", paramInfo.substring(0, 200));
        }

        System.out.println(paramInfo);
    }

    private static void testColorPattern() {
        Pattern compile = Pattern.compile("#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})");

        Matcher matcher = compile.matcher("#000000");
        System.out.println(matcher.matches());
        matcher = compile.matcher("123456");
        System.out.println(matcher.matches());

    }

    private static void testReplaceAll() {
        String s = "n. [ˈprəʊses]①过程，进程 ②工序，制作法；工艺";

       /* System.out.println(s.replace("l", "d"));
        //效果一样，支持正则
        System.out.println(s.replaceAll("l", "d"));*/

        String s1 = s.replaceAll("\\[.*\\]", "###");

        System.out.println(s1);
    }

    public static void testIndexOf() {
        String name = "pel, aaa";
        String first = "pel";

        System.out.println(name.indexOf(first));

        System.out.println("ok");
    }

    public static String getCode() {
        DateTime nowDateTime = new DateTime(Calendar.getInstance().getTime());
        int dayOfMonth = nowDateTime.getDayOfMonth();
        log.info("dayOfMonth:{}", dayOfMonth);

        Map<Integer, Date> dayTimeMap = timeMap.get(dayOfMonth);

        if (dayTimeMap == null) {
            return null;
        }

        int hourOfDay = nowDateTime.getHourOfDay();
        log.info("hourOfDay:{}", hourOfDay);

        for (Map.Entry<Integer, Date> entry : dayTimeMap.entrySet()) {
            Integer hour = entry.getKey();
            //获取下一个要参与的活动时间
            if (hour > hourOfDay) {
                DateTime hourTime = new DateTime(dayTimeMap.get(hour));
                //拼出code规则
                String code = String.format("%d%d%d", hourTime.getMonthOfYear(), hourTime.getDayOfMonth(), hourTime.getHourOfDay());
                return code;
            }
        }
        return null;
    }

    private static void testTimeMap() {

        String code = getCode();

        System.out.println(code);





        /*for (Map.Entry<Integer,Map<Integer, Date>> entry : timeMap.entrySet()) {

            Map<Integer, Date> dayTimeMap = entry.getValue();
            for (Map.Entry<Integer, Date> timeEntry : dayTimeMap.entrySet()) {
                //System.out.println(DateTimeUtil.getDateStr(timeEntry.getValue()));
                Date dateValue = timeEntry.getValue();

            }
        }*/
    }

    private static void testAtomicTest() {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.compareAndSet(0, 1));
        System.out.println(atomicInteger.compareAndSet(2, 1));
        System.out.println(atomicInteger.compareAndSet(1, 3));
        System.out.println(atomicInteger.compareAndSet(2, 4));
        System.out.println(atomicInteger.get());
    }

    private static void testJSONParse() {
        String industryId = "";
        List list = JSON.parseObject(industryId, List.class);

        System.out.println(list);
    }

    private static void testIpp() {
        int i = 0;
        i=i++;
//        int j=i++;
        System.out.println(i);
//        System.out.println(j);
    }

    private static void testZhengZe() {
        String str = "2122,133,23423";
        String regex = "^[0-9,]+$";

        System.out.println(str.matches(regex));

    }

    /*private static void testStopWatch() throws Exception{
        StopWatch sw = new StopWatch();


        for (int i = 0; i < 10; i++) {
            sw.start("i:"+i);
            System.out.println("before");
            Thread.sleep(500);
            sw.stop();
            sw.start("i:"+i);
            System.out.println("after");
            Thread.sleep(500);
            sw.stop();
        }

        StopWatch sw1 = new StopWatch();
        sw1.start("another");
        System.out.println("another");
        Thread.sleep(500);
        sw1.stop();
        System.out.println(sw1.prettyPrint());


        System.out.println("###----###");
        System.out.println(sw.prettyPrint());
        System.out.println("###----###");

//        System.out.println(new DateTime(new Date()).toString("yyyy-MM-dd"));
    }*/

    private static void testGetDigit() {
        String s = String.valueOf(111);
        System.out.println(s);
    }

    private static void testThreadCount() {

//        BeanValidators.validateWithException

        System.out.println("hello world");
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        int nowThreads = topGroup.activeCount();
        Thread[] lstThreads = new Thread[nowThreads];
        topGroup.enumerate(lstThreads);
        for (int i = 0; i < nowThreads; i++) {
            System.out.println("线程number:" + i + " = " + lstThreads[i].getName());
        }
    }

    private static void testThread() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        });

        t.start();
        t.start();
    }

    private static void testHashCode() {

        String url = "http://www.baiduhttp.com";

        //String replace = url.replace("http", "https");
        String substring = String.format("https%s", url.substring(4));

        System.out.println(substring);

        /*Integer key = 96;
        int h;
        int val = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>>16);

        System.out.println(val);*/


        /*System.out.println("a".hashCode());
        System.out.println("b".hashCode());
        System.out.println("c".hashCode());
        System.out.println("1".hashCode());
        System.out.println("2".hashCode());
        System.out.println("3".hashCode());
        System.out.println((int)"a".charAt(0));
        System.out.println((int)"b".charAt(0));
        System.out.println((int)"c".charAt(0));
        System.out.println((int)"1".charAt(0));
        System.out.println((int)"2".charAt(0));
        System.out.println((int)"3".charAt(0));*/
    }

    private static void testPriorityQueue() {
        /*Integer a = 1;
        Integer b = 2;
        System.out.println(a.compareTo(b));*/

        //小顶堆，默认容量为11
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        minHeap.add(5);
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(4);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        //大顶堆，容量11
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });

        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(4);

        /*for (int i = 0; i < 5; i++) {
            System.out.println(maxHeap.poll());
        }*/
    }

    private static void testLoopThreadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 16; i++) {
            int finalI = i;
            executor.execute(()->{
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
            });
        }
        executor.shutdown();

    }

    private static void testLoop() {
        List list = null;

        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    private static void testCommonJars() {

        //参考：https://juejin.im/post/5d4a25b351882505c105cc6e?utm_source=gold_browser_extension

        String downloadPath = "/Users/longzhiwu/Downloads/test.txt";
        System.out.println(FilenameUtils.getExtension(downloadPath));
        System.out.println(FilenameUtils.getBaseName(downloadPath));
        System.out.println(FilenameUtils.getName(downloadPath));
        System.out.println(FilenameUtils.removeExtension(downloadPath));
        System.out.println(FilenameUtils.getFullPath(downloadPath));
        System.out.println(FilenameUtils.separatorsToUnix(downloadPath));
        System.out.println(FilenameUtils.isExtension(downloadPath,"txt"));
        System.out.println(FilenameUtils.concat(downloadPath,"add"));
        System.out.println(FilenameUtils.normalize(downloadPath));
        System.out.println(FilenameUtils.wildcardMatch(downloadPath,"*.txt"));


    }

    private static void testJsArray() {
//        String str = "[\"https://cdn-zky.neibu.koo.cn/club/picture/b31ac2a4927c4a758f4a5742b77d67e0.jpg\",\"https://cdn-zky.neibu.koo.cn/club/picture/2c814a183b23430686e78768463add95.jpg\"]";

        String str = "sdfasdf";
        JSONArray jsonArray = JSONArray.parseArray(str);

        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i));
        }
    }

    private static void testNan() {
        Float a = 1f;
        Float b = 1f;

        System.out.println(a != a);
        System.out.println(Float.isNaN(a));
    }

    private static void testRandom() {

        String baseUrl = "https://yueke.neibu.koolearn.com";

        baseUrl = baseUrl.split("://")[1];
        System.out.println(baseUrl);

        Random random = new Random(100);
        System.out.println(random.nextInt(10) + "," + random.nextInt(30) + "," + random.nextInt(50));

        random = new Random(100);
        System.out.println(random.nextInt(10) + "," + random.nextInt(30) + "," + random.nextInt(50));

        random = new Random(100);
        System.out.println(random.nextInt(10) + "," + random.nextInt(30) + "," + random.nextInt(50));

    }

    private static void testBinaryInteger() {
        Integer type = 2;
        String s = Integer.toBinaryString(type);



        /*System.out.println(Integer.toBinaryString(1).charAt(1));
        System.out.println(Integer.toBinaryString(2).charAt(1));
        System.out.println(Integer.toBinaryString(3).charAt(1));*/

        /*System.out.println((type&0b10)==2);

        System.out.println((type&0b01)==1);*/

        Integer a = 0;

        Integer b = 0;

        System.out.println(a.equals(b));
    }

    private static void testJodaTime() {
        /*Date now = new Date();
        LocalDateTime courseStartDateTime = new DateTime(now).withTimeAtStartOfDay().toLocalDateTime();
        Date courseStartDate =  courseStartDateTime.toDate();
        Date courseEndDate = courseStartDateTime.plusDays(1).toDate();

        System.out.println(courseStartDate);
        System.out.println(courseEndDate);*/

        DateTime start = new DateTime(2019, 12, 21, 10, 0, 0);

        System.out.println(start.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(start.toDate());
    }

    private static void testListRemove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
    }


    private static void testTryCatchOrder() {
        Integer integer = testObjectRequireNonNull();
        log.info("integer:{}", integer);
    }

    private static Integer testObjectRequireNonNull() {
        /*File f = null;
        File file = Objects.requireNonNull(f);

        log.info("file:{}", file);*/


        try {
            log.info("try...");
            return 1;
        } catch (Exception e) {
            log.info("catch...");
        }finally {
            log.info("finally...");
        }

        return 3;
    }

    private static void testInteger() {
        System.out.println(Integer.SIZE);

        int[] a = {1, 2, 3};
        List list = CollectionUtils.arrayToList(a);

        System.out.println(list);

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
//        System.out.println(new Date().getTime());
        /*LocalDate now = LocalDate.now();
        LocalDate nextWeekMonday = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate nextWeekMonday1 = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        System.out.println(nextWeekMonday.compareTo(nextWeekMonday1));*/

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

        String dd = DurationFormatUtils.formatPeriod(System.currentTimeMillis(), sdf.parse("2018-12-11 00:00:00").getTime(), "dd");

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

        RandomUtils.nextInt();

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

        double price = 100d;
        int num = 0;
        System.out.println(price / num);
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
        /*Long aLong = Long.valueOf("");
        System.out.println("aLong = " + aLong);*/

        long interval = 1000_000_000;

        System.out.println(interval);
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
