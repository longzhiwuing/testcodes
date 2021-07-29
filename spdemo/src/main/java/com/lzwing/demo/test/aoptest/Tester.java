package com.lzwing.demo.test.aoptest;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/29
 * Time: 10:17
 */
public class Tester {


    public static void main(String[] args) {
//        testProxy();
//        aopUtilsTester();
        HelloService helloService = getProxy(new HelloServiceImpl());
        Object singletonTarget = AopProxyUtils.getSingletonTarget(helloService);

        System.out.println(singletonTarget);
    }

    private static void aopUtilsTester() {
        HelloService helloService = getProxy(new HelloServiceImpl());
        System.out.println(AopUtils.isAopProxy(helloService)); // true
        System.out.println(AopUtils.isJdkDynamicProxy(helloService)); // false
        System.out.println(AopUtils.isCglibProxy(helloService)); // true


        // 拿到目标对象
        System.out.println(AopUtils.getTargetClass(helloService)); //class com.fsx.service.HelloServiceImpl

        // selectInvocableMethod:方法@since 4.3  底层依赖于方法MethodIntrospector.selectInvocableMethod
        // 只是在他技术上做了一个判断： 必须是被代理的方法才行（targetType是SpringProxy的子类,且是private这种方法，且不是static的就不行）
        // Spring MVC的detectHandlerMethods对此方法有大量调用~~~~~
        Method method = ClassUtils.getMethod(HelloServiceImpl.class, "hello");
        System.out.println(AopUtils.selectInvocableMethod(method, HelloServiceImpl.class)); //public java.lang.Object com.fsx.service.HelloServiceImpl.hello()

        // 是否是equals方法
        // isToStringMethod、isHashCodeMethod、isFinalizeMethod  都是类似的
        System.out.println(AopUtils.isEqualsMethod(method)); //false

        // 它是对ClassUtils.getMostSpecificMethod,增加了对代理对象的特殊处理。。。
        System.out.println(AopUtils.getMostSpecificMethod(method,HelloService.class));
    }

    private static void testProxy() {
        HelloService helloService = getProxy(new HelloServiceImpl());
        System.out.println(helloService.getClass().getName());
        helloService.hello();
    }

    private static HelloService getProxy(Object targetObj){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(targetObj);
        proxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> {
            System.out.println("方法之前执行了~~~");
        });

        return (HelloService) proxyFactory.getProxy();
    }
}
