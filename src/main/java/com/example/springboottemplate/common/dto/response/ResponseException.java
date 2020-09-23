package com.example.springboottemplate.common.dto.response;

import com.example.springboottemplate.common.enums.ResponseCodeAndMsg;

/**
 * 异常返回数据结构
 */
public class ResponseException extends Response {

    public ResponseException(ResponseCodeAndMsg responseCodeAndMsg) {
        super(responseCodeAndMsg);
    }

    public ResponseException(int code, String msg) {
        super(code, msg);
    }

}
