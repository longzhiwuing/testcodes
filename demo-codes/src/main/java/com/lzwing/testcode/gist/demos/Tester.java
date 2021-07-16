package com.lzwing.testcode.gist.demos;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/5/12
 * Time: 10:30
 */
public class Tester {
    public static void main(String[] args) {
        String appId = "123423";
        TestConfig testConfig = new TestConfig(appId);

        testConfig.demo();
    }
}
