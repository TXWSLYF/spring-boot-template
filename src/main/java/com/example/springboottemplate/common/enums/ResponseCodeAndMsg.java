package com.example.springboottemplate.common.enums;

/**
 * 返回 状态码 & 状态信息 枚举
 */
public enum ResponseCodeAndMsg {

    SUCCESS(0, "success"),

    NOT_LOGGED_IN(10000, "未登录");

    private final int code;
    private final String msg;

    ResponseCodeAndMsg(int code, String msg) {
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
