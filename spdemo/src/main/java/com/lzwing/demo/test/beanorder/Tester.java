package com.lzwing.demo.test.beanorder;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/29
 * Time: 14:39
 */
public class Tester {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Config.class);
        Master.getMaster().giveFish();
        Master.getMaster().giveFish();
    }
}
