package com.lzwing.testcode.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: //这两个参数保证了堆中的可分配内存固定为20M -Xms20m -Xmx20m //文件生成的位置，作则生成在桌面的一个目录
 * -XX:+HeapDumpOnOutOfMemoryError //文件生成的位置，作则生成在桌面的一个目录 //文件生成的位置，作则生成在桌面的一个目录
 * -XX:HeapDumpPath=/Users/zdy/Desktop/dump/
 */
public class HeapOOM {
	// 创建一个内部类用于创建对象使用
	static class OOMObject {
	}

	public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        //无限创建对象，在堆中
        while (true) {
            list.add(new OOMObject());
        }
    }
}