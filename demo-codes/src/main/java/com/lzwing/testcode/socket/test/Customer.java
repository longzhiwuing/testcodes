package com.lzwing.testcode.socket.test;

import org.apache.commons.lang3.RandomUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/7/28
 * Time: 20:38
 */
public class Customer implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Socket socket = new Socket("localhost", 5001);

                PrintStream out = new PrintStream(socket.getOutputStream());

                String code = "040" + RandomUtils.nextInt(2, 7);

                out.println(code);

                //读取服务器端数据
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String ret = input.readLine();

                System.out.println("请求区号:" + code + ",服务器端返回过来的是: " + ret);

                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
