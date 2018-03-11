package com.lzwing.testcode.proxy.cglib;

import org.apache.commons.lang3.StringUtils;
import org.mockito.cglib.proxy.Enhancer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/11
 * Time: 12:16
 */
public class CglibClient {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CglibProxy());
        RealSubject realSubject = (RealSubject) enhancer.create();
        Object res = realSubject.request();
        System.out.println(res);
        System.out.println();
        print();
        realSubject.hello();
    }

    private static void print() {
        String[] header = new String[3];
        header[0] = StringUtils.repeat("*", 50);
        header[1] = StringUtils.center("  StringUtilsDemo  ", 50, "^O^");
        header[2] = header[0];
        String head = StringUtils.join(header, "\n");
        System.out.println(head);
    }
}
