package com.lzwing.testcode.utils.paramcheck;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/31
 * Time: 10:25
 */
public class DemoCheck {
    public static void main(String[] args) {

        //        testCheck();

//        testCheckArg();


//        System.out.println(lowerFirstLetter(source));

        //lombok
//        System.out.println(lowerFirstLetter4Lombok(source));
    }

    private static void testCheck() {
        String source = null;

        checkNullAble(source);
    }

    public static void testCheckArg() {
        int i = -10;

        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);

        int[] a = new int[3];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;

        checkElementIndex(0, a.length);
    }

    private static void checkNullAble(String input) {
        Optional<String> wrapped = Optional.ofNullable(input);
        System.out.println(wrapped.orElse("default"));
    }

    private static String lowerFirstLetter4Lombok(@NonNull String source) {
        return lowerFirstLetter(source);
    }

    private static String lowerFirstLetter(String source) {
        //guava
        checkArgument(StringUtils.isNotEmpty(source), "source should not null");


        //spring utils
        Assert.isTrue(StringUtils.isNotEmpty(source), "source should not null spring...");

        //jdk
        Objects.requireNonNull(null,"source should not null jdk...");

        char[] chars = source.toCharArray();

        chars[0] = (char) (chars[0] + 32);

        return new String(chars);

    }
}
