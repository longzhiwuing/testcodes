package com.lzwing.testcode.enumtest;

public enum ColorWithMethod {
    RED("红色", 1), GREEN("绿色", 2), WHITE("白色", 3), YELLO("黄色", 4);

    // 成员变量  
    private String name;
    private int index;

    // 构造方法  
    private ColorWithMethod(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法  
    public static String getName(int index) {
        for (ColorWithMethod c : ColorWithMethod.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ColorWithMethod{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}  