package com.lzwing.testcode.java8.streamapi;

import com.lzwing.testcode.java8.niceexample.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student {
    int no;
    String name;
    String sex;
    float height;

    List<Address> addressList;
}