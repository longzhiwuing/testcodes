package com.lzwing.testcode.utils.jdkcopy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/2
 * Time: 16:27
 */
@Slf4j
public class Tester {
    @Test
    public void arraysCopyOf() {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        arr = Arrays.copyOf(arr, 10);

        log.info(Arrays.toString(arr));
    }
}
