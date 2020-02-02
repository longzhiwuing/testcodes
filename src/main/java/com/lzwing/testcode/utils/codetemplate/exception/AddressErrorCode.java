package com.lzwing.testcode.utils.codetemplate.exception;

public abstract class AddressErrorCode {
    //默认地址不能删除
    public static final Long DefaultAddressNotDeleteErrorCode = 10001L;
    //找不到此收货地址
    public static final Long NotFindAddressErrorCode = 10002L;
    //找不到此用户
    public static final Long NotFindUserErrorCode = 10003L;
    //用户与收货地址不匹配
    public static final Long NotMatchUserAddressErrorCode = 10004L;
}