package com.lzwing.testcode.guice.main.demo;

import com.google.inject.Guice;
import com.lzwing.testcode.guice.main.MyApplet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/25
 * Time: 16:58
 */
public class Demo {
    public static void main(String[] args) {
        MyApplet instance = Guice.createInjector(new DemoModule()).getInstance(MyApplet.class);
        instance.run();
    }
}
