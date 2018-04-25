package com.lzwing.testcode.utils.commonjars;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 11:37
 */
public class ConvertUtilsDemo {

    public static void main(String[] args) {

        //方法测试ConvertUtils.convert，用于反射后动态把字符串参数转成相应类型

        Object convert = ConvertUtils.convert("123", Integer.class);

        System.out.println(convert);

        System.out.println(convert instanceof String);
    }
}
