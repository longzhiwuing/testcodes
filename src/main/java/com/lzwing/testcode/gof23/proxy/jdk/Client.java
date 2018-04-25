package com.lzwing.testcode.gof23.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/11
 * Time: 11:47
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxySubject(new RealSubject()));
        Object request = proxy.request();
        System.out.println(request);
        proxy.hello();

    }
}
