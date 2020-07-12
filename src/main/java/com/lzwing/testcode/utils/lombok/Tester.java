package com.lzwing.testcode.utils.lombok;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/7/12
 * Time: 23:36
 */
public class Tester {

    @SneakyThrows
    public static void main(String[] args) {
        TimeUnit.SECONDS.sleep(111);

//        String s = "你好";
//        String str = new String(s.getBytes(), StandardCharsets.UTF_8);
    }
}
