package com.lzwing.testcode.gist.demos;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/5/12
 * Time: 10:28
 */
@Data
public class TestConfig {

    private String appid;

    private final String ACCESS_TOKEN_KEY = String.format("app_%s", appid);

    public TestConfig(String appid) {
        this.appid = appid;
    }

    public void demo() {
        System.out.println(ACCESS_TOKEN_KEY);
    }
}
