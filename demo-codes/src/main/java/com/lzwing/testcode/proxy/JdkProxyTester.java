package com.lzwing.testcode.proxy;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/16
 * Time: 11:22
 */
public class JdkProxyTester {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        AccountService accountService = new AccountServiceImpl();

        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new AccountProxy(accountService)
        );

        accountServiceProxy.getAccount();
    }
}
