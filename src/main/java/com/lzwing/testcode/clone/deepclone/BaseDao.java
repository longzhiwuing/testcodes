package com.lzwing.testcode.clone.deepclone;

import java.util.List;

public interface BaseDao {
	<T> List<T> get(String id);
}