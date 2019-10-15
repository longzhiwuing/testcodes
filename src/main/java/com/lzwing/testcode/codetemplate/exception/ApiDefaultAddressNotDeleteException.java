package com.lzwing.testcode.codetemplate.exception;

public class ApiDefaultAddressNotDeleteException extends ApiException {

    public ApiDefaultAddressNotDeleteException(String message) {
        super(AddressErrorCode.DefaultAddressNotDeleteErrorCode, message, null);
    }
}