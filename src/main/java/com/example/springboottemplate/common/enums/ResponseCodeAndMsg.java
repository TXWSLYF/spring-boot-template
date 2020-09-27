package com.example.springboottemplate.common.enums;

/**
 * 返回 状态码 & 状态信息 枚举
 */
public enum ResponseCodeAndMsg {

    SUCCESS(0, "success"),

    NOT_LOGGED_IN(10000, "未登录"),
    LOG_IN_INFO_ERROR(10001, "登录信息错误"),

    JWT_PARSE_ERROR(20000, "jwt 格式错误");

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
