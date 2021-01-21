package com.lzwing.testcode.enumtest;

public class TextEnum {
    public static void main(String[] args) {
//        colorTest();
        colorWithNameTest();
    }

    private static void colorWithNameTest() {
        ColorWithMethod colorWithMethod = ColorWithMethod.WHITE;
        System.out.println("getName: " + colorWithMethod.getName());
        System.out.println("getIndex: " + colorWithMethod.getIndex());
        System.out.println("ordinal: " + colorWithMethod.ordinal());
        colorWithMethod.setName("紫色");
        colorWithMethod.setIndex(10);
        System.out.println("getName: " + colorWithMethod.getName());
        System.out.println("getIndex: " + colorWithMethod.getIndex());
        System.out.println("ordinal: " + colorWithMethod.ordinal());
    }

    private static void colorTest() {
        Enum colorRed = Color.RED;
        Enum colorBlue = Color.BLUE;
        Enum colorDark = Color.DARK;

        // 返回枚举常量数据组
        for (Color c : Color.values()) {
            System.out.println("values: " + c);
        }

        System.out.println("color = " + colorRed);
        //  compareTo比较此枚举与指定对象的顺序
        // A.compareTo(B)
        // 若A在B的后面，返回1
        // 若A在B的前面，返回-1
        System.out.println("compareTo : " + colorBlue.compareTo(colorRed));
        System.out.println("compareTo : " + colorBlue.compareTo(colorDark));
        // getDeclaringClass:返回与此枚举常量的枚举类型相对应的 Class 对象
        // 返回对象的名称包括包名
        System.out.println("getDeclaringClass: " + colorBlue.getDeclaringClass());
        // name:返回此枚举常量的名称，在其枚举声明中对其进行声明
        System.out.println("name: " + colorBlue.name());
        // ordinal:返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）
        System.out.println("ordinal: " + colorBlue.ordinal());
        // toString:返回枚举常量的名称，它包含在声明中
        System.out.println("toString: " + colorBlue.toString());
        // valueOf:返回带指定名称的指定枚举类型的枚举常量
        System.out.println("valueOf: " + Enum.valueOf(Color.class, "RED"));
    }
}  