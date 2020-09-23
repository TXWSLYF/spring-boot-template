package com.example.springboottemplate.common.exception;

import com.example.springboottemplate.common.enums.ResponseCodeAndMsg;

/**
 * 业务 api 异常
 */
public class ApiException extends RuntimeException {
    public ResponseCodeAndMsg getResponseCodeAndMsg() {
        return responseCodeAndMsg;
    }

    private ResponseCodeAndMsg responseCodeAndMsg;

    public ApiException(ResponseCodeAndMsg responseCodeAndMsg) {
        this.responseCodeAndMsg = responseCodeAndMsg;
    }

}
