package com.lzwing.testcode.guice.main.server.impl;

import com.google.common.cache.Cache;
import com.lzwing.testcode.guice.main.Logged;
import com.lzwing.testcode.guice.main.server.PaymentService;

import javax.inject.Inject;

public class PaymentServiceImpl implements PaymentService {
	private final Cache<String, String> cache;

	@Inject
	public PaymentServiceImpl(Cache<String, String> cache) {
		super();
		this.cache = cache;
	}

	@Override @Logged
	public void pay(long orderId, long price, Long sessionId) {
		// TODO Auto-generated method stub
	}

	public void putCache(String key, String value) {
		cache.put(key, value);
	}
}
