package com.lzwing.testcode.socket.test;

import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/7/28
 * Time: 20:46
 */
@Data
public class Worker extends Thread{

    private Socket socket;

    private LinkedBlockingQueue<Worker> linkedBlockingQueue;

    private Map<String, String> codeMap;

    public Worker(Map<String, String> codeMap) {
        this.codeMap = codeMap;
    }

    @Override
    public void run() {
        try {
            // 读取客户端数据
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info = input.readLine();

            String value = codeMap.get(info);

            System.out.println("客户端请求区号:" + info + "的信息,返回：" + value);

            // 向客户端回复信息
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println(value);

            linkedBlockingQueue.put(new Worker(codeMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
