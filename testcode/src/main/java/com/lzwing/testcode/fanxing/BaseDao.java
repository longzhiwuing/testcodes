package com.lzwing.testcode.fanxing;

import java.util.List;

public interface BaseDao {
	<T> List<T> get(String id);
}