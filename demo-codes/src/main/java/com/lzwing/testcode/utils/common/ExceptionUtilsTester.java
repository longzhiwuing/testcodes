package com.lzwing.testcode.utils.common;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/10/15
 * Time: 18:33
 */
public class ExceptionUtilsTester {
    public static void main(String[] args) {
        testExceptionUtils();
    }

    private static void testExceptionUtils() {
//        String message = ExceptionUtils.getMessage(new RuntimeException());


        String message = ExceptionUtils.getFullStackTrace(new RuntimeException());

        System.out.println(message);
    }
}
