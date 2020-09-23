package com.example.springboottemplate.common.dto.response;

import com.example.springboottemplate.common.enums.ResponseCodeAndMsg;

/**
 * 异常返回数据结构
 */
public class ResponseSuccess extends Response {
    private Object data;

    public ResponseSuccess(Object data) {
        super(ResponseCodeAndMsg.SUCCESS);

        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
