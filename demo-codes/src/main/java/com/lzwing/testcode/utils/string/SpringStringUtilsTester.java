package com.lzwing.testcode.utils.string;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/11/27
 * Time: 10:51
 */
public class SpringStringUtilsTester {
    public static void main(String[] args) {
        testStringUtils();
    }

    private static void testStringUtils() {
        String packageName = "tttt,;yyyy;oooo,xxxxx             hahahaha|aaaa";
        String[] PackageArray = null;
        if (org.springframework.util.StringUtils.hasLength(packageName)) {
            PackageArray = org.springframework.util.StringUtils.tokenizeToStringArray(packageName, ",; \t\n|");
        }
        for (String str : PackageArray) {
            System.out.println(str);
        }
    }
}
