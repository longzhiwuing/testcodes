package com.lzwing.testcode.errorcheck;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/7/15
 * Time: 20:22
 */
@Slf4j
public class Tester {

    @Test
    public void test() {
        //查看classpath中类是否冲突
//        Duplicate.checkDuplicate(StaticLoggerBinder.class);

        error("test", null);
    }

    //wrapper logger
    public void error(String msg, Throwable e) {
        try {
            log.error(msg + " on server " + InetAddress.getLocalHost() + " using version " + Version.getVersion(), e);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }
}
