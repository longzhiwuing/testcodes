package com.lzwing.testcode.guavacache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int no;
    String name;
    String sex;
    float height;
}