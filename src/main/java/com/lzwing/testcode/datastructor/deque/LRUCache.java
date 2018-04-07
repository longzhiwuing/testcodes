package com.lzwing.testcode.datastructor.deque;

import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap {
	
	private static final long serialVersionUID = 1L;
	protected int maxElements;

	public LRUCache(int maxSize) {
		super(maxSize, 0.75F, true);
		maxElements = maxSize;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
		// 逻辑很简单，当大小超出了Map的容量，就移除掉双向队列头部的元素，给其他元素腾出点地来。
		return size() > maxElements;
	}

}