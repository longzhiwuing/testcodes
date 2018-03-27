package com.lzwing.testcode.string;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/27
 * Time: 16:41
 */
public class ToStringBuilderDemo {

    public static void main(String[] args) {
        int[] intArr = {0, 1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(intArr));
        System.out.println(showString(intArr));

    }

    public static String showString(Object obj) {
        return ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE);
    }
}
