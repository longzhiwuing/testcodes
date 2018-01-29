package com.lzwing.testcode.streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    int no;
    String name;
    String sex;
    float height;
}