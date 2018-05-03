package com.lzwing.testcode.gof23.builder;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/3
 * Time: 16:07
 */
@Builder
@Data
public class Info {
    private String name;
    private int age;
    private String address;

}
