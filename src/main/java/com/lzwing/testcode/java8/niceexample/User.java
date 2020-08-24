package com.lzwing.testcode.java8.niceexample;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/14
 * Time: 15:43
 */
@Data
public class User implements Serializable {
    private String name;
    private Address address;
}
