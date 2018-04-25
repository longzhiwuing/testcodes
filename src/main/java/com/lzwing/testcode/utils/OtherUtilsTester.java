package com.lzwing.testcode.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/10
 * Time: 10:40
 */
public class OtherUtilsTester {
    public static void main(String[] args) {

        testFunc();


//       http://www.hutool.cn/


//        spring 相关utils
//        WebApplicationContextUtils
//        WebUtils
    }

    private static void testFunc() {
        HashMap<String, String> hashMap = new HashMap<>();

        //子-->父
        System.out.println(hashMap instanceof Map);

        //父-->子
        boolean assignableFrom = Map.class.isAssignableFrom(hashMap.getClass());

        System.out.println(assignableFrom);
    }
}
