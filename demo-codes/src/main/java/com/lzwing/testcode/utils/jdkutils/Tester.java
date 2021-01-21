package com.lzwing.testcode.utils.jdkutils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void testDeepCopys() {
        int[] arr = new int[]{1, 2, 3};

        int[] arrcopy = Arrays.copyOf(arr,arr.length);

        log.info("equal:{}", Objects.equals(arr,arrcopy));

        log.info("deepEqual:{}", Objects.deepEquals(arr, arrcopy));


        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);

        List<Integer> copyList = new ArrayList(Arrays.asList(new Object[list.size()]));

        Collections.copy(copyList, list);

        log.info("copyList:{}", copyList);


        Object[] listArr = list.toArray();
        Object[] copyArr = copyList.toArray();

        log.info("deepEqual:{}", Objects.deepEquals(listArr, copyArr));

    }
}
