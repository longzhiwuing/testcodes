/**
 * Project Name:TestCodes
 * File Name:Test.java
 * Package Name:com.test.guava
 * Date:2017年10月27日上午9:51:59
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.guava;

import com.google.common.base.*;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.*;
import com.google.common.reflect.Reflection;
import com.google.common.util.concurrent.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
public class Test {

	public static void main(String[] args) throws Exception {
		// testCheckArg();

		// testObjects();

		// testOrder();

		// testOrder2();

		// testMultiCollection();

		// testCache();
		
//		testListenableFuture();
		
//		testProxy();
		
//		testFunctional();

		testMultiSet();

	}

	public static void testMultiSet() {

		//java 1.8 map.put(val, map.getOrDefault(val, 0) + 1);

		List<String> list = Lists.newArrayList("10", "20", "hello", "hah", "hah", "hah");
		Multiset<String> set = HashMultiset.create(list);
		System.out.println(set.contains("hello"));
		System.out.println(set.count("hah"));
		System.out.println(set.count("haha"));
		System.out.println(set.elementSet().toString()+set.entrySet().toString());
	}
	
	public static void testFunctional(){
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
	
	public static void testProxy(){
		
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
	
		Greet aaa = Reflection.newProxy(Greet.class,new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("before...");
				return method.invoke(proxy, args);
			}
		});
		
		aaa.sayGoodBye();
	}
	
	public static void testString(){
		byte[] bytes = "string".getBytes(Charsets.UTF_8);
		
		CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"); // returns "constantName"
	}

	@SuppressWarnings("unchecked")
	public static void testListenableFuture() {
		final AtomicInteger atomicInteger = new AtomicInteger(0);
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		ListenableFuture explosion = service.submit(new Callable() {
			public Integer call() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("atomicInteger:"+atomicInteger);
				return atomicInteger.incrementAndGet();
			}
		});
		Futures.addCallback(explosion, new FutureCallback() {
			// we want this handler to run immediately after we push the big red
			// button!
			public void onFailure(Throwable thrown) {
				System.out.println("failure......"+thrown); // escaped the explosion!
			}

			@Override
			public void onSuccess(Object result) {
				System.out.println("start:"+result);
			}
		});
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

	public static void testObjects() {
		System.out.println(MoreObjects.toStringHelper(new Test()).add("x", 1).toString());
		;
	}

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

	public static void testMultiCollection() {
		Multimap<String, User> scoreMultimap = ArrayListMultimap.create();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("user" + i);
			user.setAge(i);
			user.setMale(i % 2 == 0);
			scoreMultimap.put("0user", user);
		}
		for (int i = 10; i < 15; i++) {
			User user = new User();
			user.setName("user" + i);
			user.setAge(i);
			user.setMale(i % 2 == 0);
			scoreMultimap.put("10user", user);
		}

		Collection<User> values = scoreMultimap.values();

		System.out.println(values);

		Collection<User> collection = scoreMultimap.asMap().get("10user");

		System.out.println(collection);

	}

	public static LoadingCache<String, User> getCache() throws ExecutionException {
		LoadingCache<String, User> users = CacheBuilder.newBuilder().maximumSize(1000)
				.expireAfterWrite(5, TimeUnit.SECONDS).build(new CacheLoader<String, User>() {
					public User load(String key) throws Exception {
						return new User(key);
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
