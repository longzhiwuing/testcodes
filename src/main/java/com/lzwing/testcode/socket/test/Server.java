package com.lzwing.testcode.socket.test;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/7/28
 * Time: 20:46
 */
public class Server {

    private static Map<String,String> codeMap = new HashMap<>();

    private static LinkedBlockingQueue<Worker> linkedBlockingQueue = new LinkedBlockingQueue<>();

    static {
        codeMap.put("0402", "石家庄");
        codeMap.put("0403", "唐山");
        codeMap.put("0404", "秦皇岛");
        codeMap.put("0405", "邯郸");
        codeMap.put("0406", "邢台");
        codeMap.put("0407", "衡水");
    }

    public static void main(String[] args) throws Exception{
        System.out.println("服务开始...");
        ServerSocket serverSocket = new ServerSocket(5001);

        for (int i = 0; i < 10; i++) {
            Worker workerThread = new Worker(codeMap);
            linkedBlockingQueue.add(workerThread);
        }

        while (true) {
            //从请求队列中取出一个连接

            Socket client = serverSocket.accept();

            Worker workThread = linkedBlockingQueue.take();

            TimeUnit.SECONDS.sleep(1);

            workThread.setLinkedBlockingQueue(linkedBlockingQueue);
            workThread.setSocket(client);

            workThread.start();
        }
    }
}
