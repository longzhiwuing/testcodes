package com.lzwing.testcode.proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/16
 * Time: 11:20
 */
public class AccountServiceImpl implements AccountService{
    @Override
    public void getAccount() {
        System.out.println("doing getAccount....");
    }
}
