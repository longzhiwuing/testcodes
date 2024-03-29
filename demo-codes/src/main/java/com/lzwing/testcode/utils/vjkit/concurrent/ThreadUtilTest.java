package com.lzwing.testcode.utils.vjkit.concurrent;

import com.vip.vjtools.vjkit.base.ObjectUtil;
import com.vip.vjtools.vjkit.base.RuntimeUtil;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ThreadUtilTest {
	@Test
	public void testCaller(){
		hello();
		new MyClass().hello();
		assertThat(RuntimeUtil.getCurrentClass()).isEqualTo("com.vip.vjtools.vjkit.concurrent.ThreadUtilTest");
		assertThat(RuntimeUtil.getCurrentMethod()).isEqualTo("com.vip.vjtools.vjkit.concurrent.ThreadUtilTest.testCaller()");
		
	}
	
	private void hello(){
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		System.out.println(ObjectUtil.toPrettyString(stacktrace));
	
		assertThat(RuntimeUtil.getCallerClass()).isEqualTo("com.vip.vjtools.vjkit.concurrent.ThreadUtilTest");
		assertThat(RuntimeUtil.getCallerMethod()).isEqualTo("com.vip.vjtools.vjkit.concurrent.ThreadUtilTest.testCaller()");
	}

	public static class MyClass{
		public void hello(){
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
			System.out.println(ObjectUtil.toPrettyString(stacktrace));
		
			assertThat(RuntimeUtil.getCallerClass()).isEqualTo("com.vip.vjtools.vjkit.concurrent.ThreadUtilTest");
			assertThat(RuntimeUtil.getCallerMethod()).isEqualTo("com.vip.vjtools.vjkit.concurrent.ThreadUtilTest.testCaller()");
		}
	}
}
