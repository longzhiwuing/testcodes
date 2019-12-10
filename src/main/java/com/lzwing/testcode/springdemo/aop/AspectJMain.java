    package com.lzwing.testcode.springdemo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop-test.xml");
        Audience audience = (Audience) context.getBean("audience");
        audience.test1();
//        audience.test2();
    }
}