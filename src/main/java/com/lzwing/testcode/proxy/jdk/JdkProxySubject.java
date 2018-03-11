package com.lzwing.testcode.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/11
 * Time: 11:43
 */
public class JdkProxySubject implements InvocationHandler {

    RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = null;
        try {
            res = method.invoke(realSubject, args);
        } catch (Exception e) {
            System.out.println("catch ex:" + e);
            throw e;
        }finally {
            System.out.println("after");
        }
        return res;
    }
}
