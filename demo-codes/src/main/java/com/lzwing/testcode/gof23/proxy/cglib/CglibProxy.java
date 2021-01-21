package com.lzwing.testcode.gof23.proxy.cglib;

import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/11
 * Time: 12:16
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before in cglib");
        Object res = null;
        try {
            res = methodProxy.invokeSuper(o, objects);
        } catch (Exception e) {
            System.out.println("catch ex:" + e);
            throw e;
        }finally {
            System.out.println("after in cglib");
        }
        return res;
    }
}
