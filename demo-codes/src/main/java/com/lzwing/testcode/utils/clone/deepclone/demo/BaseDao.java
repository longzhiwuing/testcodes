package com.lzwing.testcode.utils.clone.deepclone.demo;

import java.util.List;

public interface BaseDao {
	<T> List<T> get(String id);
}