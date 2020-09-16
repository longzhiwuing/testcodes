package com.lzwing.testcode.java8.map;

public class Student {
    //姓名
    private String name;
    //所属班级
    private Integer inClass;

    Student(String name, Integer inClass) {
        this.name = name;
        this.inClass = inClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInClass() {
        return inClass;
    }

    public void setInClass(Integer inClass) {
        this.inClass = inClass;
    }
}