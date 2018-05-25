package com.lzwing.testcode.guice.test.server.impl;

import com.google.inject.Guice;
import com.lzwing.testcode.guice.main.server.impl.PaymentServiceImpl;
import com.lzwing.testcode.guice.main.server.impl.PriceServiceImpl;
import com.lzwing.testcode.guice.main.server.impl.ServerModule;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

public class CacheTest {
	@Inject
	PaymentServiceImpl paymentService;
	@Inject
	PriceServiceImpl priceService;

	@Before public void setUp() {
		Guice.createInjector(new ServerModule())
				.injectMembers(this);
	}

	@Test
	public void testCache() {
		paymentService.putCache("testKey", "testValue");
		String cachedValue =
				priceService.getCachedValue("testKey");
		assertEquals("testValue", cachedValue);
	}

}
