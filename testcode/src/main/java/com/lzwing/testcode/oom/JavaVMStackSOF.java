package com.lzwing.testcode.oom;

/**
 * VM Args： //设置栈容量为160K，默认1M -Xss160k
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		// 递归调用，触发异常
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}