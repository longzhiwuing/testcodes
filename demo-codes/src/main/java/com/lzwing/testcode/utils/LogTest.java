package com.lzwing.testcode.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/20
 * Time: 13:40
 */
@Slf4j
public class LogTest {
    public static void main(String[] args) {
        testLog();
    }

    private static void testLog() {
        if (log.isDebugEnabled()) {
            log.debug("test....{}",executeLongTime());
        }

//        log.debug("info.....{}",executeLongTime());

        System.out.println("main logic");
    }

    private static String executeLongTime() {
        log.info("executeLongTime....");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        return "aaaa";
    }
}
