package com.lzwing.demo.test.circularref;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/8/5
 * Time: 15:44
 */
@Configuration(proxyBeanMethods = false)
public class ConstructConfig {
    @Service
    public class A {
        public A(B b) {
        }
    }
    @Service
    public class B {
        public B(A a) {
        }
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ConstructConfig.class);
    }
}
