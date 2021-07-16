package com.lzwing.testcode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/16
 * Time: 11:21
 */
public class AccountProxy implements InvocationHandler {

    private Object target;

    public AccountProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before....");
        Object result = method.invoke(target, args);
        System.out.println("after....");

        return result;
    }
}
