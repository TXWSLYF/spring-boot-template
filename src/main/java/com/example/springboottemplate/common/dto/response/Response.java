package com.example.springboottemplate.common.dto.response;

import com.example.springboottemplate.common.enums.ResponseCodeAndMsg;

/**
 * 基本返回数据结构
 */
public class Response {

    // 状态码
    private int code;

    // 消息
    private String msg;

    Response(ResponseCodeAndMsg responseCodeAndMsg) {
        this.code = responseCodeAndMsg.getCode();
        this.msg = responseCodeAndMsg.getMsg();
    }

    Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
