package com.lzwing.testcode.mockdata;

import com.lzwing.testcode.utils.vjkit.collection.MapUtilTest;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class MockUserData {

    private String name;

    private int age;

    private Date birthday;

    private List<String> stringList;

    //S/F 的枚举
    private MapUtilTest.EnumA statusEnum;

    private Map<String, String> map;
    
    //Getter & Setter
}