package com.lzwing.testcode.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        //获取构造器并进行赋值
        UserModel.User.Builder builder = UserModel.User.newBuilder();
        builder.setId(1);
        builder.setUsername("zhuanght");
        builder.setPassword("123456");
        builder.setEmail("aiuzht119@163.com");
        
        //获取实体
        UserModel.User user = builder.build();
        
        System.out.println("源数据:\r"+ user.toString());
        System.out.println("序列化后:"+ Arrays.toString(user.toByteArray()));

        //模拟接收Byte[],反序列化成User实体
        byte[] data =user.toByteArray();
        UserModel.User u = UserModel.User.parseFrom(data);
        System.out.println("\r解析:\r" +u.toString());
    }
    
}