package com.lzwing.testcode.springdemo.aop;

import org.springframework.aop.framework.AopContext;

public class Audience {

    private String name = "audience";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @watch(name = "aaa")
    public void test1() {
        //System.out.println("test1");
//        this.test2();
        //处理嵌套aop
        ((Audience)AopContext.currentProxy()).test2();
    }

    @watch(name = "bbb")
    public void test2() {
        System.out.println("test2");
    }
}