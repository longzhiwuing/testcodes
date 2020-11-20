/**
 * Project Name:TestCodes
 * File Name:Test.java
 * Package Name:com.test.guava
 * Date:2017年10月27日上午9:51:59
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 */

package com.lzwing.testcode.utils.guava;

import com.google.common.base.*;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.reflect.Reflection;
import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;

/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2017年10月27日 上午9:51:59 <br/>
 *
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
@Slf4j
public class GuavaCommonTest {

    public static void main(String[] args) throws Exception {

        testListenableFuture2();

//          testInts();

        // testCharMatcher();
        
        // testCheckArg();

        // testObjects();

        // testOrder();

        // testOrder2();

        // testCache();

//		testListenableFuture();

//		testProxy();

//		testFunctional();

//		testMultiSet();

//		 testMultiCollection();

//        testGetOrDefualt();

//        testJoinAndSplitterCharMatcher();

//        testCollection2();
//        testMultiMapIndex();
//        testMultiMap();
//        testLongParse();
    }

    private static void testCharMatcher() {
        CharMatcher charMatcherDigit = CharMatcher.digit();
        CharMatcher charMatcherBlank = CharMatcher.whitespace();

        System.out.println(charMatcherBlank.removeFrom(" good \t"));

        System.out.println(charMatcherDigit.retainFrom("abc2def1234f~"));

        System.out.println(charMatcherDigit.removeFrom("yes,i love u 1314"));

        System.out.println(CharMatcher.inRange('a','f').or(CharMatcher.is('n')).replaceFrom("zhangfengzhe","*"));
    }

    private static void testLongParse() {
        Long aLong = Longs.tryParse("123");

        Long aLong1 = Long.valueOf("123");
        long l = Long.parseLong("123");

        log.info("aLong:{}", aLong);
        log.info("aLong1:{}", aLong1);
    }

    private static void testMultiMapIndex() {
        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };

        ImmutableListMultimap<Integer, String> digitsByLength= Multimaps.index(digits, lengthFunction);
        /*
         *  digitsByLength maps:
         *  3 => {"one", "two", "six"}
         *  4 => {"zero", "four", "five", "nine"}
         *  5 => {"three", "seven", "eight"}
         */
        System.out.println("digitsByLength = " + digitsByLength);
    }

    private static void testCollection2() {
        List<String> list = Lists.newArrayList("helloworld", "yes", "longzhiwuing");

        Function<String,String> f1 = new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String s) {
                return s.length() <= 5 ? s : s.substring(0, 5);
            }
        };

        Function<String,String> f2 = new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String s) {
                return s.toUpperCase();
            }
        };

        Function<String, String> f3 = Functions.compose(f1, f2);

        Collection<String> transform = Collections2.transform(list, f3);

        transform.stream().forEach(System.out::println);
    }

    private static void testInts() {
        List<Integer> list = Ints.asList(1, 2, 3, 4, 5, 5);

        System.out.println(Ints.join(",", 1, 3, 1, 4));


        //list转int[]
        int[] newInts = Ints.toArray(list);
        System.out.println("newInts = " + Arrays.toString(newInts));

        //list转Integer[]
        Integer[] integers = list.toArray(new Integer[0]);
        //将Integer[]转换为int[]数组
        int[] ints = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();

        System.out.println(Ints.join(",",ints));

        int[] newIntArray = Ints.concat(new int[]{1, 2}, new int[]{2, 3, 4});

        System.out.println(Arrays.toString(newIntArray));

        //最大最小
        System.out.printf("%d,%d%n", Ints.max(newIntArray), Ints.min(newIntArray));

        //是否包含 不必循环
        System.out.println(Ints.contains(newIntArray, 4));


    }

    private static void testGetOrDefualt() {

        //java 1.8 map.put(val, map.getOrDefault(val, 0) + 1);

        /*Multimap<String, User> userMultimap = ArrayListMultimap.create();

        User u1 = new User().builder().isMale(false).name("zs").build();
        User u2 = new User().builder().isMale(true).name("lisi").build();
        User u3 = new User().builder().isMale(false).name("wangwu").build();

        List<User> userList = new ArrayList<>();

        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        for (User user : userList) {
            String gender = "female";
            if (user.isMale()) {
                gender = "male";
            }
            userMultimap.put(gender, user);
        }

        log.info("userMultimap:{}",userMultimap.asMap());*/

    }

    public static void testMultiSet() {

        //java 1.8 map.put(val, map.getOrDefault(val, 0) + 1);

        List<String> list = Lists.newArrayList("10", "20", "hello", "hah", "hah", "hah");
        Multiset<String> set = HashMultiset.create(list);
        System.out.println(set.contains("hello"));
        System.out.println(set.count("hah"));
        System.out.println(set.count("haha"));
        System.out.println(set.elementSet().toString() + set.entrySet().toString());
    }

    public static void testFunctional() {
		/*List<Integer> numbers = Lists.newArrayList(1, 2, 3, 6, 10, 34, 57, 89);
		Predicate<Integer> acceptEven = new Predicate<Integer>() {
		    @Override
		    public boolean apply(Integer number) {
		        return (number % 2) == 0;
		    }
		};
		List<Integer> evenNumbers = Lists.newArrayList(Collections2.filter(numbers, acceptEven));
		System.out.println(evenNumbers);
		Integer found = Collections.binarySearch(evenNumbers, 10);
		System.out.println(found);*/
		
		/*List<String> withNulls = Lists.newArrayList("a", "bc", null, "def");
		Iterable<String> withoutNuls = Iterables.filter(withNulls, Predicates.notNull());
		
		System.out.println(withoutNuls);*/
		
		/*List<Integer> evenNumbers = Lists.newArrayList(2, 6, 8, 10, 34, 90);
		Predicate<Integer> acceptEven = new Predicate<Integer>() {
		    @Override
		    public boolean apply(Integer number) {
		        return (number % 2) == 0;
		    }
		};
		boolean all = Iterables.all(evenNumbers, acceptEven);
		
		System.out.println(all);*/
		
		/*List<Integer> numbers = Lists.newArrayList(1, 2, 3);
		List<String> asStrings = Lists.transform(numbers, Functions.toStringFunction());
		
		System.out.println(asStrings);*/

        List<Integer> numbers = Arrays.asList(2, 1, 11, 100, 8, 14);
        Ordering<Object> ordering = Ordering.natural().onResultOf(Functions.toStringFunction());
        List<Integer> inAlphabeticalOrder = ordering.sortedCopy(numbers);
        System.out.println(inAlphabeticalOrder);
    }

    public static void testProxy() {

        Greet greet = new Greet() {
            @Override
            public String sayHello() {

                return "hello,greet";
            }

            @Override
            public void sayGoodBye() {
            }
        };

        greet.sayHello();

        Greet aaa = Reflection.newProxy(Greet.class, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before...");
                return method.invoke(proxy, args);
            }
        });

        aaa.sayGoodBye();
    }

    public static void testCaseFormatString() {
        byte[] bytes = "string".getBytes(Charsets.UTF_8);

        // returns "constantName"
        CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");
    }

    @SuppressWarnings("unchecked")
    public static void testListenableFuture() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture explosion = service.submit(new Callable() {
            @Override
            public Integer call() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("atomicInteger:" + atomicInteger);
                return atomicInteger.incrementAndGet();
            }
        });
        Futures.addCallback(explosion, new FutureCallback() {
            // we want this handler to run immediately after we push the big red
            // button!
            @Override
            public void onFailure(Throwable thrown) {
                // escaped the explosion!
                System.out.println("failure......" + thrown);
            }

            @Override
            public void onSuccess(Object result) {
                System.out.println("start:" + result);
            }
        },Executors.newSingleThreadExecutor());
    }

    public static void testListenableFuture2() {
        ExecutorService es = Executors.newFixedThreadPool(3);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(es);

        ListenableFuture<Integer> listenableFuture = listeningExecutorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Uninterruptibles.sleepUninterruptibly(1,TimeUnit.SECONDS);
                if (new Random().nextInt(3) == 2) {
                    throw new NullPointerException();
                }
                return 1;
            }
        });

        //回掉
        FutureCallback futureCallback = new FutureCallback<Integer>() {
            @Override
            public void onSuccess(final  Integer result) {
                System.out.println("success---:" + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.println("fail---:" + t);
            }
        };

        Futures.addCallback(listenableFuture,futureCallback,listeningExecutorService);
    }

    public static void testOptionl() {
        Optional<Integer> possible = Optional.of(5);

        System.out.println(possible.isPresent());

        System.out.println(possible.get());
    }

    public static void testCheckArg() {
        int i = -10;

        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);

        int[] a = new int[3];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;

        checkElementIndex(0, a.length);
    }

	/*public static void testObjects() {
		System.out.println(MoreObjects.toStringHelper(new Test()).add("x", 1).toString());
		;
	}*/

    public static void testCompare() {
        /*
         * return ComparisonChain.start() .compare(this.aString, that.aString)
         * .compare(this.anInt, that.anInt) .compare(this.anEnum, that.anEnum,
         * Ordering.natural().nullsLast()) .result();
         */
    }

    public static void testOrder() {
        List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");

        System.out.println("list:" + list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
        System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitraryOrdering:" + arbitraryOrdering.sortedCopy(list));
    }

    public static void testOrder2() {
        List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");

        System.out.println("list:" + list);

        Ordering<String> naturalOrdering = Ordering.natural();
        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));

        List<Integer> listReduce = Lists.newArrayList();
        for (int i = 9; i > 0; i--) {
            listReduce.add(i);
        }

        List<Integer> listtest = Lists.newArrayList();
        listtest.add(1);
        listtest.add(1);
        listtest.add(1);
        listtest.add(2);

        Ordering<Integer> naturalIntReduceOrdering = Ordering.natural();

        System.out.println("listtest:" + listtest);
        System.out.println(naturalIntReduceOrdering.isOrdered(listtest));
        System.out.println(naturalIntReduceOrdering.isStrictlyOrdered(listtest));

        System.out.println("naturalIntReduceOrdering:" + naturalIntReduceOrdering.sortedCopy(listReduce));
        System.out.println("listReduce:" + listReduce);

        System.out.println(naturalIntReduceOrdering.isOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));
        System.out.println(naturalIntReduceOrdering.isStrictlyOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));

        Ordering<String> natural = Ordering.natural();

        List<String> abc = ImmutableList.of("a", "b", "c");
        System.out.println(natural.isOrdered(abc));
        System.out.println(natural.isStrictlyOrdered(abc));

        System.out.println("isOrdered reverse :" + natural.reverse().isOrdered(abc));

        List<String> cba = ImmutableList.of("c", "b", "a");
        System.out.println(natural.isOrdered(cba));
        System.out.println(natural.isStrictlyOrdered(cba));
        System.out.println(cba = natural.sortedCopy(cba));

        System.out.println("max:" + natural.max(cba));
        System.out.println("min:" + natural.min(cba));

        System.out.println("leastOf:" + natural.leastOf(cba, 2));
        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
        System.out.println("leastOf list:" + naturalOrdering.leastOf(list, 3));
        System.out.println("greatestOf:" + naturalOrdering.greatestOf(list, 3));
        System.out.println("reverse list :" + naturalOrdering.reverse().sortedCopy(list));
        System.out.println("isOrdered list :" + naturalOrdering.isOrdered(list));
        System.out.println("isOrdered list :" + naturalOrdering.reverse().isOrdered(list));
        list.add(null);
        System.out.println(" add null list:" + list);
        System.out.println("nullsFirst list :" + naturalOrdering.nullsFirst().sortedCopy(list));
        System.out.println("nullsLast list :" + naturalOrdering.nullsLast().sortedCopy(list));
    }

    public static LoadingCache<String, User> getCache() throws ExecutionException {
        LoadingCache<String, User> users = CacheBuilder.newBuilder().maximumSize(1000)
                .expireAfterWrite(5, TimeUnit.SECONDS).build(new CacheLoader<String, User>() {
                    public User load(String key) throws Exception {
                        return new User(key,0,true);
                    }
                });
        return users;
    }

    public static void testCache() throws ExecutionException, InterruptedException {
        String name = "zhangsan";

        LoadingCache<String, User> cache = getCache();

        User user = cache.get(name);

        System.out.println("first:" + user);

        user = cache.get(name);

        System.out.println("second:" + user);

        Thread.sleep(3000);

        user = cache.get(name);

        System.out.println("third:" + user);
    }

}
