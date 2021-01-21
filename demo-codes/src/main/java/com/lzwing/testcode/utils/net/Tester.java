package com.lzwing.testcode.utils.net;

import org.apache.rocketmq.remoting.common.RemotingUtil;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * 获取进程号的方法
 *
 * rocketmq 获取ip的方法
 *
 * @author: chenzhongyong
 * Date: 2020/6/28
 * Time: 11:35
 */
public class Tester {

    public static void main(String[] args) {
        System.out.println(getPid());

        System.out.println(RemotingUtil.getLocalAddress());
    }

    public static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        // format: "pid@hostname"
        String name = runtime.getName();
        try {
            return Integer.parseInt(name.substring(0, name.indexOf('@')));
        } catch (Exception e) {
            return -1;
        }
    }
}
