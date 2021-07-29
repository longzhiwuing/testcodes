package com.lzwing.demo.test.aoptest;

public class HelloServiceImpl implements HelloService {
    @Override
    public Object hello() {
        System.out.println("this is my method~~");
        return "service hello";
    }
	// 准备一个私有方法，测试用
    private void privateMethod() {
        System.out.println("privateMethod");
    }
}