package com.lzwing.testcode.guice.main.server.impl;

import com.google.common.cache.AbstractCache;

import javax.inject.Singleton;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class GuiceDemoCache
	extends AbstractCache<String, String> {

	private final Map<String, String> keyValues =
			new ConcurrentHashMap<>();

	@Override
	public String getIfPresent(Object key) {
		return keyValues.get(key);
	}

	@Override
	public void put(String key, String value) {
		keyValues.put(key, value);
	}
}
