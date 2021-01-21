package com.lzwing.testcode.oom;

import java.lang.reflect.Method;

public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		/*while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			// 无限创建动态代理，生成Class对象
			enhancer.create();
		}*/
	}

	static class OOMObject {

	}
}