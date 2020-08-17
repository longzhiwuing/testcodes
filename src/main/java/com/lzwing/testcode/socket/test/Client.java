package com.lzwing.testcode.socket.test;

public class Client {

    public static void main(String[] args) {
        System.out.println("客户端开始请求.....");

        for (int i = 0; i < 5; i++) {
            new Thread(new Customer(), "customer_" + i).start();
        }
    }
}