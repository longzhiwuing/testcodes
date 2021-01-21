package com.lzwing.testcode.processbuilder;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/10/15
 * Time: 18:49
 */
public class Tester {
    public static void main(String[] args) throws Exception{
        Process  p =new ProcessBuilder("ping","www.baidu.com").start();
        InputStream inputStream = p.getInputStream();

        byte[] bytepool = new byte[1024];
        StringBuffer sb = new StringBuffer();
        String line;

        while (inputStream.read(bytepool) != -1L) {
            line = new String(bytepool, "utf-8");
            System.out.println("取出进程中数据+" + line);
            sb.append(line);
            sb.append("\n");
        }

        inputStream.close();
    }
}
