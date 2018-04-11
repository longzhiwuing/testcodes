package com.lzwing.testcode.paramcheck;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/31
 * Time: 10:25
 */
public class DemoCheck {
    public static void main(String[] args) {
        String source = null;


        System.out.println(lowerFirstLetter(source));

        //lombok
//        System.out.println(lowerFirstLetter4Lombok(source));
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
