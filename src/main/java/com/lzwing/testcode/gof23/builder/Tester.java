package com.lzwing.testcode.gof23.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/3
 * Time: 16:08
 */
@Slf4j
public class Tester {
    public static void main(String[] args) {
        Info info = Info.builder()
                .name("zhangsan")
                .age(14)
                .address("beijing").build();

        log.info("{}",info);

        info.setName("lisi");
        info.setAge(55);
        info.setAddress("shanghai");

        log.info("{}",info);

    }
}
