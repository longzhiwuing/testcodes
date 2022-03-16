package com.lzwing.testcode.mockdata;

import com.github.houbb.data.factory.core.util.DataUtil;
import com.lzwing.testcode.gof23.builder.Info;
import lombok.extern.slf4j.Slf4j;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2022/3/16
 * Time: 22:48
 */
@Slf4j
public class RandomGeneratePOJOTester {

    public static void main(String[] args) {
        testPodam();
        testDataUtil();
    }

    private static void testDataUtil() {
        MockUserData mockUserData = DataUtil.build(MockUserData.class);

        System.out.println(mockUserData);
    }

    private static void testPodam() {
        PodamFactory podamFactory = new PodamFactoryImpl();

        MockUserData mockUserData = podamFactory.manufacturePojo(MockUserData.class);

        System.out.println(mockUserData);
    }
}
